package com.hpcl.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hpcl.entity.Dealer;


public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
