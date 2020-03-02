package joycai.springboot.model;

import javax.persistence.*;
import javax.xml.soap.Text;

@Entity
@Table(name = "t_mobile")
public class MobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    long id;

    String mobile;
    String userId;
    Long  timesmp;
    byte[] data;
    public MobileEntity() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public MobileEntity(String mobile, String userId, Long timesmp) {
        this.mobile = mobile;
        this.userId = userId;
        this.timesmp = timesmp;
    }

    public MobileEntity(byte[] data, String userId, long timesmp) {
        this.data = data;
        this.userId = userId;
        this.timesmp = timesmp;
    }

    public Long getTimesmp() {
        return timesmp;
    }

    public void setTimesmp(Long timesmp) {
        this.timesmp = timesmp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
