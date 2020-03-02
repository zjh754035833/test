package joycai.springboot.model;

import java.math.BigDecimal;

public class Messagemodal {
    Long id;

    String usermessage;
    Long  mtimesmp;
    String userid;
    Long num;
    String sendstate;
    Long  sendtime;
    String username;
    BigDecimal mobileprice;
    String sate;
    long pageCounts;
    public Long getId() {
        return id;
    }

    public BigDecimal getMobileprice() {
        return mobileprice;
    }

    public void setMobileprice(BigDecimal mobileprice) {
        this.mobileprice = mobileprice;
    }

    public long getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(long pageCounts) {
        this.pageCounts = pageCounts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsermessage() {
        return usermessage;
    }

    public String getSate() {
        return sate;
    }

    public void setSate(String sate) {
        this.sate = sate;
    }

    public void setUsermessage(String usermessage) {
        this.usermessage = usermessage;
    }

    public Long getMtimesmp() {
        return mtimesmp;
    }

    public void setMtimesmp(Long mtimesmp) {
        this.mtimesmp = mtimesmp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getSendstate() {
        return sendstate;
    }

    public void setSendstate(String sendstate) {
        this.sendstate = sendstate;
    }

    public Long getSendtime() {
        return sendtime;
    }

    public void setSendtime(Long sendtime) {
        this.sendtime = sendtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
