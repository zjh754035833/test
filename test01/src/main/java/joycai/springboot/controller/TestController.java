package joycai.springboot.controller;

import com.google.common.base.Strings;
import com.mysql.cj.util.StringUtils;
import joycai.springboot.model.*;
import joycai.springboot.repository.MessageRepository;
import joycai.springboot.repository.MobileRepository;
import joycai.springboot.repository.UserRepository;
import joycai.springboot.service.UserAccountService;
import joycai.springboot.util.Tokenutil;
import org.redisson.Redisson;
import org.redisson.api.RQueue;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Collectors;
@EnableCaching
@RestController
public class TestController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MobileRepository mobileRepository;

    private UserAccountService userAccountService;
    private MobileEntity mobileEntity;

    @Autowired
    public TestController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @RequestMapping("login")
    public Properties login(HttpServletRequest request) {
        String user_name = request.getParameter("user_name");
        String pass_word = request.getParameter("pass_word");
        Properties str = new Properties();
        String tokenval = "";
        if (!(StringUtils.isNullOrEmpty(user_name)) && !(StringUtils.isNullOrEmpty(pass_word))) {
            UserEntity userEntity = userAccountService.findByUseNameVal(user_name);
            if (userEntity == null) {
                str.setProperty("state", "0");
                str.setProperty("msg", "登录失败，用户不存在");
            } else {
                if (userEntity.getUserpassword().equals(pass_word)) {
                    tokenval = Tokenutil.makeToken();
                    userEntity.setUsertoken(tokenval);
                    str.setProperty("token", tokenval);
                    str.setProperty("state", "1");
                    str.setProperty("msg", "登录成功");
                    userAccountService.save(userEntity);
                } else {
                    str.setProperty("state", "0");
                    str.setProperty("msg", "登录失败：密码错误");
                }
            }
        } else {
            str.setProperty("state", "0");
            str.setProperty("msg", "登录失败：用户名密码不能为空");
        }
        return str;
    }
    @RequestMapping("updateUser")
    public Properties updateUser(HttpServletRequest request) {
        Properties str = new Properties();
        String useNameVal = request.getParameter("usenameval");
        String passWordVal = request.getParameter("passwordval");
        String newPassWordVal = request.getParameter("newpasswordval");
        if (!(StringUtils.isNullOrEmpty(useNameVal)) && !(StringUtils.isNullOrEmpty(passWordVal))) {
            UserEntity userEntity = userAccountService.findByUseNameVal(useNameVal);
            if (userEntity == null) {
                str.setProperty("state", "0");
                str.setProperty("msg", "登录已失效，请重新登录");
            } else {
                if (userEntity.getUserpassword().equals(passWordVal)) {
                    userEntity.setUserpassword(newPassWordVal);
                    userAccountService.save(userEntity);
                    str.setProperty("state", "2");
                    str.setProperty("msg", "修改密码成功，请用新密码重新登录");
                } else {
                    str.setProperty("state", "1");
                    str.setProperty("msg", "修改失败：原密码和账号不匹配");
                }
            }
        } else {
            str.setProperty("state", "0");
            str.setProperty("msg", "登录失败：用户名密码不能为空");
        }
        return str;
    }
    @RequestMapping("register")
    public synchronized InsertMobileResponse register(HttpServletRequest request) {
        String useNameVal = request.getParameter("usenameval");
        String token = request.getParameter("token");
        String passWordVal = request.getParameter("passwordval");
        String mobilePriceVal = request.getParameter("mobilepriceval");
        InsertMobileResponse response = new InsertMobileResponse();

        UserEntity userEntity = userAccountService.findByToken(token);
        if (userEntity == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
        } else {
            UserEntity oldUerEntity = userAccountService.findByUseNameVal(useNameVal);
            if (oldUerEntity != null) {
                response.setMsg("该账户已被注册");
                response.setState("1");
            } else {
                BigDecimal money = new BigDecimal(0.0);
                BigDecimal mobilePrice = new BigDecimal(mobilePriceVal);
                String isAdmin = "n";
                UserEntity newUserEntity = new UserEntity(useNameVal, passWordVal, money, isAdmin, mobilePrice);
                userAccountService.save(newUserEntity);
                response.setMsg("开户成功");
                response.setState("1");
            }
        }
        return response;

    }
    @RequestMapping("insertMobile")
    public InsertMobileResponse insertMobile(@RequestBody UserDto userDto) throws IOException {
        InsertMobileResponse response = new InsertMobileResponse();
        String token = userDto.getToken();
        String textarea = userDto.getTextarea();
        String sendTime = userDto.getSendtime();
        UserEntity userEntity = userAccountService.findByToken(token);
        if (userEntity == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {
            List<String> newList =new ArrayList<>();
            userDto.getPhonelist().stream().distinct().forEach(phone -> {
                newList.add(phone);
            });
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                        arrayOutputStream);
                objectOutputStream.writeObject(newList);
                objectOutputStream.flush();
                byte[] data = arrayOutputStream.toByteArray();
                objectOutputStream.close();
                arrayOutputStream.close();

            long timesmp = System.currentTimeMillis();

            MobileEntity entity = new MobileEntity(data, userEntity.getId().toString(), timesmp);
            this.mobileRepository.save(entity);
           /* Config  config = new Config();
            config.useSingleServer().setAddress("redis://localhost:6379");
            Redisson redisson = (Redisson) Redisson.create(config);
            RQueue<String> myQueue= redisson.getQueue("FirstQueue");
            myQueue.clear();


            userDto.getPhonelist().forEach(phone -> {
                myQueue.add(phone);
            });

               System.out.println("ALLMOBILE"+myQueue);*/

/*
            long timesmp = System.currentTimeMillis();
            userAccountService.saveMobiles(
                    myQueue,userEntity.getId().toString(), timesmp*/
                        /*    .stream()
                            .distinct()
                            .map(phone -> {
                                MobileEntity entity = new MobileEntity(phone, userEntity.getId().toString(), timesmp);
                                return entity;
                            })
                            .collect(Collectors.toList())*/
            /*);*/

            MessageEntity msgEntity = new MessageEntity(timesmp, userEntity.getId().toString(), userDto.getPhonelist().stream().distinct().count(), "0", textarea, Long.parseLong(sendTime),userEntity.getMobileprice(),"n");

            userAccountService.saveMesAg(msgEntity);
            response.setState("1");


            return response;
        }
    }

    @RequestMapping("upDataMobile")
    public InsertMobileResponse updataMobile(HttpServletRequest request) {

        InsertMobileResponse response = new InsertMobileResponse();
        String token = request.getParameter("token");
        String userId = request.getParameter("userid");
        String timeSmpStr = request.getParameter("timesmpstr");
        UserEntity userState = userAccountService.findByToken(token);
        //UserEntity userEntity = userAccountService.findById(Long.parseLong(userid));
        if (userState == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {

            MessageEntity messagentity = userAccountService.findSendMsg(userId, Long.parseLong(timeSmpStr));
            ArrayList<MobileEntity> mobileList = new ArrayList<>();
            List<MobileEntity> mobileEntity = userAccountService.findMobileNow(userId, Long.parseLong(timeSmpStr));
            mobileList=this.getInfoListFromBytes(mobileEntity.get(0).getData());
            response.setValist(mobileList);
            response.setState("1");
            response.setMessage(messagentity);
            return response;
        }
    }
    @Transactional
    @RequestMapping("upDateAll")
    public InsertMobileResponse upDateAll(@RequestBody UserDto userDto) throws IOException {
        InsertMobileResponse response = new InsertMobileResponse();
        String token = userDto.getToken();
        String userId = userDto.getUserid();
        String textarea = userDto.getTextarea();
        Long msgNum =Long.parseLong(userDto.getMsgNum());
        Long sendTime = Long.parseLong(userDto.getSendtime());
        Long timeSmpStr = Long.parseLong(userDto.getTimesmpstr());

        UserEntity userEntity = userAccountService.findByToken(token);
        if (userEntity == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {
            List<String> newList =new ArrayList<>();
            Long timeSmpStrNow =  System.currentTimeMillis();

            mobileRepository.deleteAllByUserIdAndTimesmp(userId, timeSmpStr);
            userDto.getPhonelist().stream().distinct().forEach(phone -> {
                newList.add(phone);
            });
            byte[] data = this.getInfoBytesFromObject(newList);

            MobileEntity entity = new MobileEntity(data, userEntity.getId().toString(), timeSmpStrNow);

            this.mobileRepository.save(entity);
            MessageEntity messageEntity = messageRepository.findByUserIdAndMtimeSmp(userId, timeSmpStr);
            messageEntity.setUsermessage(textarea);
            messageEntity.setSendtime(sendTime);
            messageEntity.setNum(newList.stream().count());
            messageEntity.setSate("g");
            messageEntity.setMtimeSmp(timeSmpStrNow);
            messageRepository.save(messageEntity);
            //update mobile recs

            response.setMsg("修改成功");
            response.setState("1");
            return response;
        }
    }
    @RequestMapping("exportMobile")
    public InsertMobileResponse exportMobile(HttpServletRequest request) {
        InsertMobileResponse response = new InsertMobileResponse();
        String token = request.getParameter("token");
        String userId = request.getParameter("userid");
        String timeSmpStr = request.getParameter("timesmpstr");
        UserEntity userState = userAccountService.findByToken(token);
        //UserEntity userEntity = userAccountService.findById(Long.parseLong(userid));
        if (userState == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {
            MessageEntity messagentity = userAccountService.findSendMsg(userId, Long.parseLong(timeSmpStr));

            ArrayList<MobileEntity> mobileList = new ArrayList<>();

            List<MobileEntity> mobileEntity = userAccountService.findMobileNow(userId, Long.parseLong(timeSmpStr));
            mobileList=this.getInfoListFromBytes(mobileEntity.get(0).getData());

            response.setMessage(messagentity);
            response.setValist(mobileList);
            return response;
        }
    }

    @RequestMapping("updateSendNum")
    public InsertMobileResponse updateSendNum(HttpServletRequest request) {
        InsertMobileResponse response = new InsertMobileResponse();
        String token = request.getParameter("token");
        String userId = request.getParameter("userId");
        String timeSmpStr = request.getParameter("timeSmpStr");
        String sendState = request.getParameter("sendState");
        UserEntity userState = userAccountService.findByToken(token);
        //UserEntity userEntity = userAccountService.findById(Long.parseLong(userId));
        if (userState == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {

            MessageEntity messageEntity = userAccountService.findSendMsg(userId, Long.parseLong(timeSmpStr));
            messageEntity.setSendstate(sendState);
            userAccountService.saveMesAg(messageEntity);
            response.setState("1");
            response.setMessage(messageEntity);
            return response;
        }
    }
    @RequestMapping("isAdmin")
    public InsertMobileResponse isAdmin(HttpServletRequest request) {
        InsertMobileResponse response = new InsertMobileResponse();
        String token = request.getParameter("token");
        if ((StringUtils.isNullOrEmpty(token))) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {
            UserEntity userEntity = userAccountService.findByToken(token);
            if (userEntity == null) {
                response.setState("0");
                response.setMsg("登录状态失效，请重新登录");
            } else {
                if (userEntity.getIsadmin().equals("y")) {
                    response.setMsg("admin");
                    response.setState("1");
                }else{
                    response.setMsg("user");
                    response.setState("1");
                }
            }
        }
        return response;
    }

    @RequestMapping("userInfo")
    public InsertMobileResponse userInfo(HttpServletRequest request) {
        InsertMobileResponse response = new InsertMobileResponse();
        String sendStart=request.getParameter("sendStart");
        String sendEnd=request.getParameter("sendEnd");
        String insertStart=request.getParameter("insertStart");
        String insertEnd=request.getParameter("insertEnd");
        String p = request.getParameter("page");
        String token = request.getParameter("token");
        String sendUser = request.getParameter("senduser");

        if ((StringUtils.isNullOrEmpty(token))) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {

            UserEntity userEntity = userAccountService.findByToken(token);

            if (userEntity == null) {
                response.setState("0");
                response.setMsg("登录状态失效，请重新登录");
            } else {
                if (userEntity.getIsadmin().equals("y")) {
                    String newSendUser="";


                    UserEntity userInfo = userAccountService.finBySendUser(sendUser);
                    if(userInfo!=null){
                        newSendUser=Long.toString(userInfo.getId());
                    }else{
                        newSendUser="";
                    }
                    Page<MessageEntity> mesEntity = userAccountService.findAll(p,sendStart,sendEnd,insertStart,insertEnd,newSendUser);


                    long pagecounts = mesEntity.getTotalElements();
                    Set<Long> uidSet = mesEntity.stream()
                            .map(it -> Long.parseLong(it.getUserId()))
                            .collect(Collectors.toSet());
                    List<UserEntity> userList = userRepository.findAllById(uidSet);
                    Map<Long, String> userNameMap = userList.stream().collect(
                            Collectors.toMap(UserEntity::getId, v -> v.getUsername())
                    );

                    List<Messagemodal> msgList = mesEntity.getContent().stream()
                            .map(entity -> {
                                Messagemodal dto = new Messagemodal();

                                dto.setUsername(
                                        userNameMap.get(
                                                Long.parseLong(entity.getUserId())
                                        )
                                );
                                dto.setId(entity.getId());
                                dto.setNum(entity.getNum());
                                dto.setMtimesmp(entity.getMtimeSmp());
                                dto.setSendstate(entity.getSendstate());
                                dto.setSendtime(entity.getSendtime());
                                dto.setUserid(entity.getUserId());
                                dto.setUsermessage(entity.getUsermessage());
                                dto.setMobileprice(entity.getMobileprice());
                                dto.setSate(entity.getSate());
                                return dto;
                            }).collect(Collectors.toList());

                    response.setUsername(userEntity.getUsername());
                    response.setPageCounts(pagecounts);
                    response.setMsg("admin");
                    response.setState("1");
                    response.setDto(msgList);
                } else if (userEntity.getIsadmin() == null || !userEntity.getIsadmin().equals("y")) {
                    Page<MessageEntity> mesEntity = userAccountService.findMessage(userEntity.getId().toString(), p);
                long pagecounts = mesEntity.getTotalElements();
                    Set<Long> uidSet = mesEntity.stream()
                            .map(it -> Long.parseLong(it.getUserId()))
                            .collect(Collectors.toSet());
                    List<UserEntity> userList = userRepository.findAllById(uidSet);
                    Map<Long, String> userNameMap = userList.stream().collect(
                            Collectors.toMap(UserEntity::getId, v -> v.getUsername())
                    );

                    List<Messagemodal> msgList = mesEntity.getContent().stream()
                            .map(entity -> {
                                Messagemodal dto = new Messagemodal();

                                dto.setUsername(
                                        userNameMap.get(
                                                Long.parseLong(entity.getUserId())
                                        )
                                );
                                dto.setId(entity.getId());
                                dto.setNum(entity.getNum());
                                dto.setMtimesmp(entity.getMtimeSmp());
                                dto.setSendstate(entity.getSendstate());
                                dto.setSendtime(entity.getSendtime());
                                dto.setUserid(entity.getUserId());
                                dto.setUsermessage(entity.getUsermessage());
                                dto.setMobileprice(entity.getMobileprice());
                                return dto;
                            }).collect(Collectors.toList());
                    response.setUsername(userEntity.getUsername());
                    response.setPageCounts(pagecounts);
                    response.setState("1");
                    response.setMsg(userEntity.getMoney().toString());
                    response.setDto(msgList);
                }
            }
            return response;
        }

    }

    @RequestMapping("deleteMobile")
    public InsertMobileResponse deleteMobile(HttpServletRequest request) {
        InsertMobileResponse response = new InsertMobileResponse();
        String token = request.getParameter("token");
        String userId = request.getParameter("userid");
        String timeSmpStr = request.getParameter("timesmpstr");
        UserEntity userState = userAccountService.findByToken(token);
        //UserEntity userEntity = userAccountService.findById(Long.parseLong(userid));
        if (userState == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {

            MessageEntity messagentity = userAccountService.findSendMsg(userId, Long.parseLong(timeSmpStr));
            messagentity.setSate("y");
            messageRepository.save(messagentity);
            response.setState("1");
            response.setMessage(messagentity);
            return response;
        }

    }
    @RequestMapping("forReally")
    public InsertMobileResponse forReally(HttpServletRequest request) {
        InsertMobileResponse response = new InsertMobileResponse();
        String token = request.getParameter("token");
        String userId = request.getParameter("userid");
        String timeSmpStr = request.getParameter("timesmpstr");
        UserEntity userState = userAccountService.findByToken(token);
        //UserEntity userEntity = userAccountService.findById(Long.parseLong(userid));
        if (userState == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {

            MessageEntity messagentity = userAccountService.findSendMsg(userId, Long.parseLong(timeSmpStr));
            messagentity.setSate("n");
            messageRepository.save(messagentity);
            response.setState("1");
            response.setMessage(messagentity);
            return response;
        }

    }
    @RequestMapping("userAllList")
        public AlluserModel userAllList(HttpServletRequest  request){
            AlluserModel response = new AlluserModel();
            String p = request.getParameter("page");
            String token = request.getParameter("token");
            if ((StringUtils.isNullOrEmpty(token))) {
                response.setMsg("登录状态失效，请重新登录");
                response.setState("0");
                return response;
            } else {
                UserEntity userEntity = userAccountService.findByToken(token);
                if (userEntity == null) {
                    response.setState("0");
                    response.setMsg("登录状态失效，请重新登录");
                }else{

                        Page<UserEntity> userEntityPage = userAccountService.findAll(p);
                    List<Usermodel> usermodelList = userEntityPage.getContent().stream().map( usr -> {
                       Usermodel usermodel = new Usermodel();
                       usermodel.setUsername(usr.getUsername());
                       usermodel.setMobilePrice(usr.getMobileprice());
                       usermodel.setIsadmin(usr.getIsadmin());
                       return usermodel;
                   }
                   ).collect(Collectors.toList());
                    long pagecounts = userEntityPage.getTotalElements();
                    response.setPageCounts(pagecounts);
                    response.setUsermodels(usermodelList);
                    response.setState("1");
                }
                return response;
            }
        }
    @Transactional
    @RequestMapping("deleteMobileAdmin")
    public InsertMobileResponse deleteMobileAdmin(HttpServletRequest request) {
        InsertMobileResponse response = new InsertMobileResponse();
        String token = request.getParameter("token");
        String userId = request.getParameter("userid");
        String timeSmpStr = request.getParameter("timesmpstr");
        UserEntity userState = userAccountService.findByToken(token);
        //UserEntity userEntity = userAccountService.findById(Long.parseLong(userid));
        if (userState == null) {
            response.setMsg("登录状态失效，请重新登录");
            response.setState("0");
            return response;
        } else {

            MessageEntity messagentity = userAccountService.findSendMsg(userId, Long.parseLong(timeSmpStr));

            mobileRepository.deleteAllByUserIdAndTimesmp(userId, Long.parseLong(timeSmpStr));
            messageRepository.delete(messagentity);
            response.setState("1");
            response.setMessage(messagentity);
            return response;
        }

    }

    public byte[] getInfoBytesFromObject(List<String> list) {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    arrayOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.flush();
            byte[] data = arrayOutputStream.toByteArray();
            objectOutputStream.close();
            arrayOutputStream.close();
            return data;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    private ArrayList<MobileEntity> getInfoListFromBytes(byte[] bytes) {
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream inputStream = new ObjectInputStream(
                    arrayInputStream);
            ArrayList<MobileEntity> list = (ArrayList<MobileEntity>) inputStream
                    .readObject();
            inputStream.close();
            arrayInputStream.close();
            return list;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
