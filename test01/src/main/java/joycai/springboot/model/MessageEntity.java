package joycai.springboot.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_message")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String userId;
    Long num;
    String sate;

    String usermessage;
    Long    mtimeSmp;
    String sendstate;
    Long  sendtime;
    BigDecimal mobileprice;
    public MessageEntity() {

    }


    public String getSate() {
        return sate;
    }

    public void setSate(String sate) {
        this.sate = sate;
    }

    public BigDecimal getMobileprice() {
        return mobileprice;
    }

    public void setMobileprice(BigDecimal mobileprice) {
        this.mobileprice = mobileprice;
    }

    public MessageEntity(long timesmp, String toString, long count, String s, String textarea, long sendtime,BigDecimal mobileprice,String state) {
        this.usermessage = textarea;
        this.mtimeSmp = timesmp;
        this.userId = toString;
        this.num = count;
        this.sendstate = s;
        this.sendtime = sendtime;
        this.mobileprice=mobileprice;
        this.sate=state;
    }


    public Long getSendtime() {
        return sendtime;
    }

    public void setSendtime(Long sendtime) {
        this.sendtime = sendtime;
    }

    public String getSendstate() {
        return sendstate;
    }

    public void setSendstate(String sendstate) {
        this.sendstate = sendstate;
    }



    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getMtimeSmp() {
        return mtimeSmp;
    }

    public void setMtimeSmp(Long mtimeSmp) {
        this.mtimeSmp = mtimeSmp;
    }

    public String getUsermessage() {
        return usermessage;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }


}
