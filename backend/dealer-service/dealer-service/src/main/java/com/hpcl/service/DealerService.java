package com.hpcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hpcl.dto.DealerRegisteredEvent;
import com.hpcl.entity.Dealer;
import com.hpcl.kafka.DealerEventProducer;
import com.hpcl.repository.DealerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;
    private final DealerEventProducer eventProducer;

    public Dealer createDealer(Dealer dealer) {
        dealer.setActive(true);
        Dealer savedDealer = dealerRepository.save(dealer);

        DealerRegisteredEvent event = new DealerRegisteredEvent(
                savedDealer.getDealerCode(),
                savedDealer.getName(),
                savedDealer.getLocation()
        );

        eventProducer.publishDealerRegisteredEvent(event);

        return savedDealer;
    }

    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    public Dealer getDealer(Long id) {
        return dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer not found"));
    }
}
