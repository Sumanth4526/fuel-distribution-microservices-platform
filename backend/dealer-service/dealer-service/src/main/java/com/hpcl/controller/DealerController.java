package com.hpcl.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hpcl.entity.Dealer;
import com.hpcl.service.DealerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/dealers")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;

    @PostMapping
   public Dealer createDealer(@RequestHeader("X-ROLE") String role,@RequestBody Dealer dealer) {
    	if(!role.equals("ADMIN")) {
    		throw new RuntimeException("Access Denied");
    	}
	   return dealerService.createDealer(dealer);
   }
    
    @GetMapping
    public List<Dealer> getAllDealers(@RequestHeader("X-ROLE") String role) {
    	if(!role.equals("ADMIN")) {
    		throw new RuntimeException("Access Denied");
    	}
    	return dealerService.getAllDealers();
    }
    

    @GetMapping("/{id}")
    public Dealer getDealer(@PathVariable Long id) {
        return dealerService.getDealer(id);
    }
}
