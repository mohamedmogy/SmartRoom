package com.amqp.consumer.smarthome.receiver;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import com.amqp.consumer.smarthome.CustomMessage;
import com.amqp.consumer.smarthome.smar_db.myEntity;
import com.amqp.consumer.smarthome.smar_db.SmartRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

    private double temp;
    private double humd;
    private int num = 0;
    private CountDownLatch latch = new CountDownLatch(1);
    @Autowired
    Sender sender;

   @Autowired
    private SmartRepository myrepository;

    @RabbitListener(queues = "sensorQueue1")
    public void receiveMessage(final CustomMessage message) throws IOException {



        myEntity myentity = new myEntity();
        myentity.setHumidity(message.getHumidity());
        myentity.setMotion(message.getMotion());
        myentity.setTemperature(message.getTemperature());
        myentity.setTimestamp(message.getTimestamp());
        myentity.setTypeID(message.getTypeID());
        myrepository.save(myentity);




        if(message.getTypeID() == 2)
        {
            this.temp = message.getTemperature();
            this.humd = message.getHumidity();
            System.out.println("Temp: " + this.temp +" Humd: " + this.humd);
        }
        else
        {
            if(message.getMotion().equals ("in"))
            {
                this.num = this.num + 1;
                System.out.println("number of ppl in is : " + this.num);
            }
            else if (message.getMotion().equals("out"))
            {
                this.num = this.num - 1;
                System.out.println("number of ppl in is : " + this.num);
            }
        }

        if ( this.temp > 30.0 && this.num > 0)
        {
            System.out.println("Turn on AC");
            sender.sendMessage("ONAC");

        }
        else
        {
            System.out.println("Turn off AC");
            sender.sendMessage("OFFAC");
        }

        if ( this.humd > 35.0 && this.num >0)
        {
            System.out.println("Turn on VENT");
            sender.sendMessage("ONVENT");
        }
        else
        {
            if(this.num <=5){
                System.out.println("TURN OFF VENT");
                sender.sendMessage("OFFVENT");}
        }

        if (this.num > 5)
        {
            System.out.println("Turn on VENT");
            sender.sendMessage("ONVENT");
        }
        else
        {
            if (this.humd <=35){
                System.out.println("Turn OFF VENT");
                sender.sendMessage("OFFVENT");}
        }
        //latch.countDown();
    }

    /* @RabbitListener(queues = "sensorQueue2")
     public void receiveMessage1(String message) throws IOException {
          System.out.println(message);
     }*/

    public CountDownLatch getLatch() {
        return latch;
    }

}