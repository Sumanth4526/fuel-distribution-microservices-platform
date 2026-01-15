package com.hpcl.service;




import java.util.List;

import org.springframework.stereotype.Service;

import com.hpcl.entity.Dealer;
import com.hpcl.repository.DealerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;

    public Dealer createDealer(Dealer dealer) {
        dealer.setActive(true);
        return dealerRepository.save(dealer);
    }

    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    public Dealer getDealer(Long id) {
        return dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer not found"));
    }
}
