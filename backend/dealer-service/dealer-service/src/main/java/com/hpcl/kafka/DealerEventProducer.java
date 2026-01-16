package com.hpcl.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.hpcl.dto.DealerRegisteredEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DealerEventProducer {

    private final KafkaTemplate<String, DealerRegisteredEvent> kafkaTemplate;
    private static final String TOPIC = "dealer-registered";

    public void publishDealerRegisteredEvent(DealerRegisteredEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }

}
