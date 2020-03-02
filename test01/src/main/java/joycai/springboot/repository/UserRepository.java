package joycai.springboot.repository;


import joycai.springboot.model.MessageEntity;
import joycai.springboot.model.MobileEntity;
import joycai.springboot.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsertoken(String token);
    UserEntity findById(long parseLong);

    UserEntity findByUsername(String usenameval);





  /*  List<UserEntity> findByPrizeId(int priceId);
    Page<UserEntity> findByPrizeId(int priceId , PageRequest page);*/

}

