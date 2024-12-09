package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.Admin;
import com.example.capstone2.Model.Bidding;
import com.example.capstone2.Model.Car;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.AdminRepository;
import com.example.capstone2.Repository.BiddingRepository;
import com.example.capstone2.Repository.CarRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BiddingServicce {
    private final BiddingRepository biddingRepository;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final CarRepository carRepository;


    public List<Bidding> getAllBidding(){
        return biddingRepository.findAll();
    }


    public Bidding getBiddingById(Integer id){
        Bidding bidding= biddingRepository.findBiddingById(id);
        if(bidding==null){
            throw new ApiExcption("Bidding not found");
        }
        return bidding;

    }


    public void addBidding(Integer seller , Bidding bidding){
       User buyeer = userRepository.findUserById(bidding.getBidder());
       User seller1 = userRepository.findUserById(seller);
//       Car car = carRepository.findCarByIdAndUserId(bidding.getCarId(), bidding.getSeller());
       if (buyeer !=null) {
//           if (car != null) {
//               bidding.getStartBidding();
//                   bidding.setBidder(buyeer.getId());
                bidding.setSeller(seller1.getId());
               biddingRepository.save(bidding);
//           }else throw new ApiExcption("Car not found");

       }else throw new ApiExcption("not found");
    }

    public Bidding highestBid(Integer carId){
        Bidding bidding = biddingRepository.findTopByCarIdOrderByBidAmountDesc(carId);

        if(bidding==null){
            throw new ApiExcption("Car not found");
        }
        return bidding;
    }


    public void buy(Integer adminId , Integer biddingId){
        Bidding bidding = biddingRepository.findBiddingById(biddingId);
        Admin admin = adminRepository.findAdminById(adminId);
        User buyer = userRepository.findUserById(bidding.getBidder());
        User seller = userRepository.findUserById(bidding.getSeller());
        Car car = carRepository.findCarById(bidding.getCarId());

        if (admin!=null){
            if (bidding!=null){
                if (buyer.getBalance()>=bidding.getPrice()){
                    buyer.setBalance(buyer.getBalance()-bidding.getPrice());
                    seller.setBalance(seller.getBalance()+bidding.getPrice());
                    car.setUserId(bidding.getBidder());
                    bidding.setSuccess(true);
                    biddingRepository.save(bidding);
                    carRepository.save(car);
                    userRepository.save(buyer);
                    userRepository.save(seller);
                }else throw new ApiExcption("balance is less");
            }else throw new ApiExcption("bidding not found");

        }else throw new ApiExcption("admin not found");
    }















}
