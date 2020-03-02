package joycai.springboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlluserModel {

    String state = null;
    Long pageCounts=null;
    String msg = null;
    List<Usermodel> usermodels =null;
    public AlluserModel() {

    }

    public List<Usermodel> getUsermodels() {
        return usermodels;
    }

    public void setUsermodels(List<Usermodel> usermodels) {
        this.usermodels = usermodels;
    }

    public AlluserModel(String state, Long pageCounts, String msg, String username, BigDecimal mobilePrice) {
        this.state = state;
        this.pageCounts = pageCounts;
        this.msg = msg;

    }






    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public Long getPageCounts() {
        return pageCounts;
    }

    public void setPageCounts(Long pageCounts) {
        this.pageCounts = pageCounts;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public void setDto(Page<UserEntity> userEntityPage) {
    }
}
