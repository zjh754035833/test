package joycai.springboot.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InsertMobileResponse {
    MessageEntity message =null;
    List<MobileEntity> items = null;
    List<MessageEntity> msgitems=null;
 ArrayList<MobileEntity> valist=null;
Map<String,List> maplist=null;
List<Messagemodal> dto=null;
    String state = null;
    Page<MessageEntity>pageitems=null;
    Long pageCounts=null;
    String msg = null;
    String username=null;
//    Map<String, String> result = Maps.newHashMap();

    public Long getPageCounts() {
        return pageCounts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPageCounts(Long pageCounts) {
        this.pageCounts = pageCounts;
    }

    public List<Messagemodal> getDto() {
        return dto;
    }

    public void setDto(List<Messagemodal> dto) {
        this.dto = dto;
    }

    public Page<MessageEntity> getPageitems() {
        return pageitems;
    }

    public void setPageitems(Page<MessageEntity> pageitems) {
        this.pageitems = pageitems;
    }

    public MessageEntity getMessage() {
        return message;
    }

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    public List<MobileEntity> getItems() {
        return items;
    }

    public Map<String, List> getMaplist() {
        return maplist;
    }

    public void setMaplist(Map<String, List> maplist) {
        this.maplist = maplist;
    }

    public ArrayList<MobileEntity> getValist() {
        return valist;
    }

    public List<MessageEntity> getMsgitems() {
        return msgitems;
    }

    public void setMsgitems(List<MessageEntity> msgitems) {
        this.msgitems = msgitems;
    }

    public void setValist(ArrayList<MobileEntity> valist) {
        this.valist = valist;
    }

    public void setItems(List<MobileEntity> items) {
        this.items = items;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
