package com.example.capstone2.Repository;

import com.example.capstone2.Model.Bidding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BiddingRepository extends JpaRepository<Bidding, Integer> {

    Bidding findBiddingById(Integer id);
    @Query("SELECT b FROM Bidding b WHERE b.carId = :carId ORDER BY b.price DESC")
    Bidding findTopByCarIdOrderByBidAmountDesc(Integer carId);
}
