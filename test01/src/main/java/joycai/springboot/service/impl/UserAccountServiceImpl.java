package joycai.springboot.service.impl;

import com.google.common.collect.Queues;
import joycai.springboot.model.MessageEntity;
import joycai.springboot.model.MobileEntity;
import joycai.springboot.model.UserEntity;
import joycai.springboot.repository.MessageRepository;
import joycai.springboot.repository.MobileRepository;
import joycai.springboot.repository.UserRepository;
import joycai.springboot.service.UserAccountService;
import joycai.springboot.util.RedisUtil;

import org.redisson.api.RQueue;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service("UserAccountService")
@EnableCaching
public class UserAccountServiceImpl implements UserAccountService  {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MobileRepository mobileRepository;
    @Autowired
    MessageRepository messageRepository;


    RedisUtil redisUtil;





    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByToken(String token) {
        return userRepository.findByUsertoken(token);
    }


    @Override
    public void saveMesAg(MessageEntity msgentity) {
       messageRepository.save(msgentity);
    }
    @Autowired
    private RedisTemplate redisTemplate;

        @Override
        public void saveMobiles(RQueue<String> myQueue, String toString, long timesmp) {
            Queue<String> myQueue1 =Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue0 =Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue2 = Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue3 =Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue4 = Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue5 =Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue6 = Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue7 =Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue8 = Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue9 =Queues.newConcurrentLinkedQueue();
            Queue<String> myQueue10 = Queues.newConcurrentLinkedQueue();
            int num =myQueue.size();
            if(num<=10){
                while( !myQueue.isEmpty()) {
                        myQueue0.offer(myQueue.poll());
                    }
                Thread a =new Thread(new RedisUtil(myQueue0,mobileRepository,toString,timesmp));
                a.start();
                return;
            }
            int i1=0;

            while( i1< num/10) {
                if(myQueue.size()>0){
                    myQueue1.offer(myQueue.poll());
                    i1++;
                }
            }
            System.out.println(myQueue);
            int i2=0;
            while( i2<num/10) {
                if(myQueue.size()>0){
                    myQueue2.offer(myQueue.poll());
                    i2++;
                }
            }
            System.out.println(myQueue);
            int i3=0;
            while( i3<num/10) {
                if(myQueue.size()>0){
                    myQueue3.offer(myQueue.poll());
                    i3++;
                }
            }
            System.out.println(myQueue);
            int i4=0;
            while( i4<num/10) {
                if(myQueue.size()>0){
                    myQueue4.offer(myQueue.poll());
                    i4++;
                }
            }
            System.out.println(myQueue);
            int i5=0;
            while( i5<num/10) {
                if(myQueue.size()>0){
                    myQueue5.offer(myQueue.poll());
                    i5++;
                }
            }
            System.out.println(myQueue);
            int i6=0;
            while( i6<num/10) {
                if(myQueue.size()>0){
                    myQueue6.offer(myQueue.poll());
                    i6++;
                }
            }
            System.out.println(myQueue);
            int i7=0;
            while( i7<num/10) {
                if(myQueue.size()>0){
                    myQueue7.offer(myQueue.poll());
                    i7++;
                }
            }
            System.out.println(myQueue);
            int i8=0;
            while( i8<num/10) {
                if(myQueue.size()>0){
                    myQueue8.offer(myQueue.poll());
                    i8++;
                }
            }
            System.out.println(myQueue);
            int i9=0;
            while( i9<num/10) {
                if(myQueue.size()>0){
                    myQueue9.offer(myQueue.poll());
                    i9++;
                }
            }
            System.out.println(myQueue);
            while( myQueue.size()>0) {
                    myQueue10.offer(myQueue.poll());
            }

            Thread a1 =new Thread(new RedisUtil(myQueue1,mobileRepository,toString,timesmp));
            Thread a2 =new Thread(new RedisUtil(myQueue2,mobileRepository,toString,timesmp));
            Thread a3 =new Thread(new RedisUtil(myQueue3,mobileRepository,toString,timesmp));
            Thread a4 =new Thread(new RedisUtil(myQueue4,mobileRepository,toString,timesmp));
            Thread a5 =new Thread(new RedisUtil(myQueue5,mobileRepository,toString,timesmp));
            Thread a6 =new Thread(new RedisUtil(myQueue6,mobileRepository,toString,timesmp));
            Thread a7 =new Thread(new RedisUtil(myQueue7,mobileRepository,toString,timesmp));
            Thread a8 =new Thread(new RedisUtil(myQueue8,mobileRepository,toString,timesmp));
            Thread a9 =new Thread(new RedisUtil(myQueue9,mobileRepository,toString,timesmp));
            Thread a10 =new Thread(new RedisUtil(myQueue10,mobileRepository,toString,timesmp));
            a1.start();
            a2.start();
            a3.start();
            a4.start();
            a5.start();
            a6.start();
            a7.start();
            a8.start();
            a9.start();
            a10.start();
     /*    new Thread(new RedisUtil(mobileEntityList.subList(1000, 2000),mobileRepository),"线程2").start();
        new Thread(new RedisUtil(mobileEntityList.subList(2000, 3000),mobileRepository),"线程3").start();
       new Thread(new RedisUtil(mobileEntityList.subList(3000, 4000),mobileRepository),"线程4").start();
        new Thread(new RedisUtil(mobileEntityList.subList(4000, 5000),mobileRepository),"线程5").start();
        new Thread(new RedisUtil(mobileEntityList.subList(5000, 6000),mobileRepository),"线程6").start();
        new Thread(new RedisUtil(mobileEntityList.subList(6000, 7000),mobileRepository),"线程7").start();
        new Thread(new RedisUtil(mobileEntityList.subList(7000, 8000),mobileRepository),"线程8").start();*/

        /*     int step = 100;*/
     /*   for (int start = 0; start < 100; start += step) {
            int end = start + step;
            if (end > mobileEntityList.size()-1) {
                end = mobileEntityList.size() - 1;
            }*/
        /*long stTime = System.currentTimeMillis();*/
        //  mobileRepository.saveAll(mobileEntityList/*.subList(start, end)*/);
          /*  long edTime = System.currentTimeMillis();
            long used = edTime - stTime;
            System.out.println("time:" + used);*/
        /*}*/

    }

    @Override
    public UserEntity finBySendUser(String sendUser) {
        UserEntity userEntity =userRepository.findByUsername(sendUser);
        return  userEntity;
    }


    @Override
    public Page<MessageEntity> findMessage(String toString,String p) {
        Page<MessageEntity> daTas = messageRepository.findByUserIdAndSateNotOrderByMtimeSmpDesc(toString,"y",PageRequest.of(Integer.parseInt(p),10));
            return  daTas;
    }


    @Override
    public MessageEntity findSendMsg(String toString, long timeSmp) {
        return  messageRepository.findByUserIdAndMtimeSmp(toString,timeSmp);
    }

    @Override
    public List<MobileEntity> findMobileNow(String toString, long timesmp) {
        return  mobileRepository.findByUserIdAndTimesmp(toString,timesmp);
    }



    @Override
    public Page<MessageEntity> findAll(String p,String sendstate,String sendend,String insertStart, String insertEnd,String sendUser) {
        Sort sort = new Sort(Sort.Direction.DESC, "mtimeSmp");

        if(sendstate!=null&sendstate!=""&sendend!=null&sendend!=""){
            Page<MessageEntity> datas = messageRepository.findBySendtimeBetween(Long.parseLong(sendstate),Long.parseLong(sendend),PageRequest.of(Integer.parseInt(p),10,sort ));
            return  datas;
        }else if(insertStart!=null&insertStart!=""&insertEnd!=null&insertEnd!=""){
            Page<MessageEntity> datas = messageRepository.findByMtimeSmpBetween(Long.parseLong(insertStart),Long.parseLong(insertEnd),PageRequest.of(Integer.parseInt(p),10,sort ));
            return  datas;
        }else if(sendUser!=null&sendUser!=""){
            Page<MessageEntity> datas = messageRepository.findByUserId(sendUser,PageRequest.of(Integer.parseInt(p),10,sort ));
            return  datas;
        }else{
            Page<MessageEntity> datas = messageRepository.findAll( PageRequest.of(Integer.parseInt(p),10,sort ));
            return  datas;
        }


    }

    @Override
    public Page<UserEntity> findAll(String p) {
        Page<UserEntity> datas = userRepository.findAll( PageRequest.of(Integer.parseInt(p),10));
        return  datas;
    }


    @Override
    public UserEntity findByUseNameVal(String usenameval) {
        return userRepository.findByUsername(usenameval);
    }






}
