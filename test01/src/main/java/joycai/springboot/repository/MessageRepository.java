package joycai.springboot.repository;


import joycai.springboot.model.MessageEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    MessageEntity findByUserIdAndMtimeSmp(String toString, long timesmp);

    Page<MessageEntity> findByUserIdAndSateNotOrderByMtimeSmpDesc(String toString, String n, Pageable of);

    Page<MessageEntity> findBySendtimeBetween(Long sendState, Long sendEnd, Pageable of);

    Page<MessageEntity> findByMtimeSmpBetween(long parseLong, long parseLong1, Pageable of);

    Page<MessageEntity> findByUserId(String sendUser, Pageable of);
}

