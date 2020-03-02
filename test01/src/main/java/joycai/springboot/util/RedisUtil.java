package joycai.springboot.util;

import joycai.springboot.model.MobileEntity;
import joycai.springboot.repository.MobileRepository;
import org.redisson.api.RQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Component
public class RedisUtil implements Runnable {

    @Autowired
    MobileRepository mobileRepository;

private  Queue<String> myQueue ;
private String Id;
private  Long TimeSmp;

  public RedisUtil(){

    }

    public RedisUtil(Queue<String> myQueue1, MobileRepository mobileRepository, String toString, long timesmp) {
        this.myQueue=myQueue1;
        this.mobileRepository=mobileRepository;
        this.Id=toString;
        this.TimeSmp=timesmp;
    }



    @Override
    public void run() {
        List<MobileEntity> mobileEntityList = new ArrayList<MobileEntity>();
        while (!this.myQueue.isEmpty()){
            //System.out.println(this.myQueue.size());
            try {
                 MobileEntity entity = new MobileEntity(myQueue.poll(),Id, TimeSmp);
                 mobileEntityList.add(entity);
             //   System.out.println(this.myQueue.size());

            }catch (Exception e){
                e.printStackTrace();
            }
        }
         mobileRepository.saveAll(mobileEntityList);
        }



}
