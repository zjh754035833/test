package joycai.springboot.repository;


import joycai.springboot.model.MessageEntity;
import joycai.springboot.model.MobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MobileRepository extends JpaRepository<MobileEntity, Long> {


    List<MobileEntity> findByUserIdAndTimesmp(String toString, long timesmp);


    Long deleteAllByUserIdAndTimesmp(String toString, long timesmp);




   


  /*  List<UserEntity> findByPrizeId(int priceId);
    Page<UserEntity> findByPrizeId(int priceId , PageRequest page);*/

}

