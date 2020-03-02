package joycai.springboot.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false, unique = true)
    String username;

    String userpassword;

    String usertoken;

    BigDecimal money;
    String isadmin;
    BigDecimal mobileprice;
    public UserEntity() {

    }



    public UserEntity(String username, String userpassword, BigDecimal money, String isadmin, BigDecimal mobileprice) {
        this.username = username;
        this.userpassword = userpassword;
        this.money = money;
        this.isadmin = isadmin;
        this.mobileprice = mobileprice;
    }

    public BigDecimal getMobileprice() {
        return mobileprice;
    }

    public void setMobileprice(BigDecimal mobileprice) {
        this.mobileprice = mobileprice;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
