package com.mihaifilipdud.rabbitmqdemo.consumer;

import com.mihaifilipdud.rabbitmqdemo.config.MessagingConfig;
import com.mihaifilipdud.rabbitmqdemo.dto.MonitoredData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class User {

//    @RabbitListener(queues = MessagingConfig.QUEUE)
//    public void consumeMessageFromQueue(MonitoredData monitoredData){
//        System.out.println("Message: " + monitoredData);
//    }
}
