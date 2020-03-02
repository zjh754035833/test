package joycai.springboot.service;

import joycai.springboot.model.MessageEntity;
import joycai.springboot.model.MobileEntity;
import joycai.springboot.model.UserEntity;
import org.redisson.api.RQueue;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Queue;

public interface UserAccountService {

    UserEntity save(UserEntity userEntity);

   UserEntity findByToken(String token);

    void saveMesAg(MessageEntity msgEntity);


    Page<MessageEntity> findMessage(String toString,String p);

    MessageEntity findSendMsg(String toString, long timeSmp);

    List<MobileEntity> findMobileNow(String toString, long timeSmp);



    UserEntity findByUseNameVal(String useNameVal);


    Page<MessageEntity> findAll(String p, String sendStart, String sendEnd, String insertStart, String insertEnd,String sendUser);
    Page<UserEntity> findAll(String p);
    void saveMobiles(RQueue<String> myQueue, String toString, long timesmp);

    UserEntity finBySendUser(String sendUser);
}
