package com.mihaifilipdud.rabbitmqdemo.publisher;

import com.mihaifilipdud.rabbitmqdemo.DataAcquisition.MonitoredDataReceiver;
import com.mihaifilipdud.rabbitmqdemo.config.MessagingConfig;
import com.mihaifilipdud.rabbitmqdemo.dto.MonitoredData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
@CrossOrigin
public class MessageDataPublisher {

    @Autowired
    private RabbitTemplate template;

    @GetMapping("/push")
    public String monitoredActivity() throws InterruptedException {

        List<MonitoredData> activities = MonitoredDataReceiver.getData();
        for(MonitoredData m : activities){
            System.out.println(m);
            template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, m);
            Thread.sleep(1000);
        }

        return "Success";
    }
}
