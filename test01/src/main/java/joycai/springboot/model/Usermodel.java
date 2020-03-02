package joycai.springboot.model;

import java.math.BigDecimal;

public class Usermodel {
    String username=null;
    BigDecimal mobilePrice;
    String isadmin =null;
    public String getUsername() {
        return username;
    }

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getMobilePrice() {
        return mobilePrice;
    }

    public void setMobilePrice(BigDecimal mobilePrice) {
        this.mobilePrice = mobilePrice;
    }
}
