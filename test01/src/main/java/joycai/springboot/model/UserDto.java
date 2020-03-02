package joycai.springboot.model;

import java.util.List;

public class UserDto {

    List<String> phonelist;
    String token;
    String textarea;
    String sendtime;
    String userid;
    String timesmpstr;
    String msgNum;

    public List<String> getPhonelist() {
        return phonelist;
    }

    public String getUserid() {
        return userid;
    }

    public String getMsgNum() {
        return msgNum;
    }

    public void setMsgNum(String msgNum) {
        this.msgNum = msgNum;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTimesmpstr() {
        return timesmpstr;
    }

    public void setTimesmpstr(String timesmpstr) {
        this.timesmpstr = timesmpstr;
    }

    public void setPhonelist(List<String> phonelist) {
        this.phonelist = phonelist;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }
}
