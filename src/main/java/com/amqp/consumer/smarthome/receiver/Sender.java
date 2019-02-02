package com.amqp.consumer.smarthome.receiver;


import com.amqp.consumer.smarthome.CustomMessage;
import com.amqp.consumer.smarthome.SmartHomeApplication;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;
import java.util.logging.Logger;

@Service
public class Sender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public Sender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String x) {
      //  final CustomMessage message = new CustomMessage( new Random().nextInt(50),new Random().nextInt(50),"message" ,new Date());
      //  System.out.println("sending messages...."+message.toString());

        rabbitTemplate.setExchange(SmartHomeApplication.topicExchangeName1);
        rabbitTemplate.setRoutingKey("send");
        rabbitTemplate.setQueue("sensorQueue2");
        rabbitTemplate.convertAndSend(x);

    }


}
