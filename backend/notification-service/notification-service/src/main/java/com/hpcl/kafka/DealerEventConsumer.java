package com.hpcl.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.hpcl.dto.DealerRegisteredEvent;

@Component
public class DealerEventConsumer {

    @KafkaListener(topics = "dealer-registered", groupId = "notification-group")
    public void consumeDealerRegisteredEvent(DealerRegisteredEvent event) {
        System.out.println("📢 Dealer Registered Notification");
        System.out.println("Dealer Code: " + event.getDealerCode());
        System.out.println("Dealer Name: " + event.getName());
        System.out.println("Location: " + event.getLocation());
        System.out.println("Email/SMS notification triggered");
    }

}
