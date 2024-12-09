package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.*;
import com.example.capstone2.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final AdminRepository adminRepository;
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void addTransaction(Integer adminId  , Integer buyer , Integer seller , Transaction transaction) {
//        User user1 = userRepository.findUserById(buyer);
//        User user2 = userRepository.findUserById(seller);
        Car car = carRepository.findCarByIdAndUserId(transaction.getCarId() , seller);
        Admin admin = adminRepository.findAdminById(adminId);
//        if (user1!=null){
//            if (user2!=null){
//                if (car!=null){
                    if (admin!=null){
                        transaction.setBuyerID(buyer);
                        transaction.setSellerID(seller);
                        transaction.setCarId(car.getId());
                        transactionRepository.save(transaction);
                    }else throw new ApiExcption("admin is not found");
//                }else throw new ApiExcption("car is not found");
//            }else throw new ApiExcption("seller is not found");
//        }else throw new ApiExcption("buyer is not found");

    }

    public void updateTransaction(Integer id ,Transaction transaction) {
        Transaction transaction1 = transactionRepository.findTransactionById(id);

        if(transaction1 != null) {
            transaction1.setTransactionDate(transaction.getTransactionDate());
            transaction1.setBuyerID(transaction.getBuyerID());
            transaction1.setSellerID(transaction.getSellerID());
            transaction1.setCarId(transaction.getCarId());
            transactionRepository.save(transaction1);



        }
        throw new ApiExcption("not found");
    }

    public void deleteTransaction(Integer id) {
        Transaction transactionToDelete = transactionRepository.findTransactionById(id);

        if (transactionToDelete != null) {
            transactionRepository.delete(transactionToDelete);
        }
        throw new ApiExcption("not found");
    }


//    Integer userId1, Integer userId2 , Integer carId ,
    public void BuyOfCar( Integer adminId , Integer id ) {
        Transaction transaction = transactionRepository.findTransactionById(id);
        User buyer = userRepository.findUserById(transaction.getBuyerID());
        User seller = userRepository.findUserById(transaction.getSellerID());
        Car car = carRepository.findCarById(transaction.getCarId());
        Admin admin = adminRepository.findAdminById(adminId);

        if (buyer!=null){
            if (seller!=null){
                if (admin!=null){
                    if (car!=null){
                        if(transaction.getTransactionType().equalsIgnoreCase("Instant sale")){
                            if (transaction.getPrice()!=0){
                                if (buyer.getBalance()>=transaction.getPrice()){
                                    transaction.getTransactionDate();
                                    buyer.setBalance(buyer.getBalance()-transaction.getPrice());
                                    seller.setBalance(seller.getBalance()+transaction.getPrice());
                                    car.setUserId(buyer.getId());
                                    transaction.setStatus(true);
                                    transactionRepository.save(transaction);
                                    userRepository.save(buyer);
                                    userRepository.save(seller);
                                    adminRepository.save(admin);
                                }else throw new ApiExcption("Wallet balance is less than the car price. Please deposit money.");
                            }else throw new ApiExcption("You must enter a selling price.");
                        }else throw new ApiExcption("type of transaction is not supported");
                    }else throw new ApiExcption("car is not found");

                }else throw new ApiExcption("admin is not found");

            }else throw new ApiExcption("buyer is not found");

        }else throw new ApiExcption("buyer is not found");

    }


    public List<Transaction> findByStatus(Boolean status) {
        List<Transaction> transactions = transactionRepository.findTransactionByStatus(status);
        if (transactions != null) {
            return transactions;
        }
        throw new ApiExcption("transaction not found");
    }

    public Transaction findTransactionById(Integer id) {
        Transaction transaction = transactionRepository.findTransactionById(id);
        if (transaction != null) {
            return transaction;
        }
        throw new ApiExcption("transaction not found");
    }









}
