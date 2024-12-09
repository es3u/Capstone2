package com.example.capstone2.Controller;

import com.example.capstone2.Model.Bidding;
import com.example.capstone2.Service.BiddingServicce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bidding")
@RequiredArgsConstructor
public class BiddingController {
    private final BiddingServicce biddingServicce;
    @GetMapping("/getAllBidding")
    public ResponseEntity getAllBidding(){
        return ResponseEntity.ok(biddingServicce.getAllBidding());
    }
    @GetMapping("/getBiddingById/{biddingId}")
    public ResponseEntity getBiddingById(@PathVariable Integer biddingId){
        return ResponseEntity.ok(biddingServicce.getBiddingById(biddingId));
    }
    @PostMapping("/addBidding/{id}")
    public ResponseEntity addBidding(@PathVariable Integer id , @RequestBody@Valid Bidding bidding , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        biddingServicce.addBidding(id ,bidding);
        return ResponseEntity.ok().body("Added bidding successfully");
    }
    @GetMapping("/highestBid/{carId}")
    public ResponseEntity highestBid(@PathVariable Integer carId){
       Bidding bidding =  biddingServicce.highestBid(carId);
        return ResponseEntity.ok().body(bidding);
    }
    @PutMapping("/buy/{adminId}/{biddingId}")
    public ResponseEntity buy(@PathVariable Integer adminId ,@PathVariable Integer biddingId){
        biddingServicce.buy(adminId,biddingId);
        return ResponseEntity.ok().body("Buy successfully");
    }








}
