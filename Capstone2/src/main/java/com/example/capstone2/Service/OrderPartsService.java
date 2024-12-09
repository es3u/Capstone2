package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.*;
import com.example.capstone2.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderPartsService {

    private final OrderPartsRepository orderPartsRepository;
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final SparePartsRepository sparePartsRepository;


    public List<OrderParts> getAllOrderParts(){
        return orderPartsRepository.findAll();
    }

    public void addOrderParts(OrderParts orderParts){
//        Admin admin = adminRepository.findAdminById(orderParts.getAdminId());
        Car car = carRepository.findCarById(orderParts.getCarId() );
        User user = userRepository.findUserById(orderParts.getUserId());

        SpareParts sparePart = sparePartsRepository.findSparePartsById(orderParts.getSparePartId());
//        if (admin != null && admin.getLoggedin()  ){
            if (user!=null && user.getLoggedin()){
                if (car != null){
                    orderParts.setTotalPrice(sparePart.getPartPrice());
                    orderPartsRepository.save(orderParts);

                }else throw new ApiExcption("car is not found");

            }else throw new ApiExcption("user is not found or not logged in ");

//        }else throw new ApiExcption("admin is not found or not login");

    }

    public void updateOrderParts(Integer id ,OrderParts orderParts){
        OrderParts orderParts1 = orderPartsRepository.findOrderPartsById(id);
        if (orderParts1 != null){
            orderParts1.setCarId(orderParts.getCarId());
            orderParts1.setUserId(orderParts.getUserId());
            orderPartsRepository.save(orderParts1);
        }
        throw new ApiExcption("orderParts is not found");
    }

    public void deleteOrderParts(Integer id){
        OrderParts orderParts1 = orderPartsRepository.findOrderPartsById(id);
        if (orderParts1 != null){
            orderPartsRepository.delete(orderParts1);
        }
        throw new ApiExcption("orderParts is not found");
    }

    public void buyOfSparePart(Integer adminId , Integer quantity, Integer orderid) {
        OrderParts orderParts = orderPartsRepository.findOrderPartsById(orderid);
        Admin admin = adminRepository.findAdminById(adminId);
        User user = userRepository.findUserById(orderParts.getUserId());
        SpareParts spareParts = sparePartsRepository.findSparePartsById(orderParts.getSparePartId());
        orderParts.setTotalPrice(orderParts.getTotalPrice()*quantity);
        if(user != null) {
            if(user.getLoggedin() != null) {
                if (spareParts != null) {
                    if (spareParts.getAvailabilityStock()!=0) {
                        if (spareParts.getAvailabilityStock()>quantity) {
                            if(orderParts.getTotalPrice()<user.getBalance()){
                                if (admin!=null && admin.getLoggedin()) {
                                    user.setBalance(user.getBalance()-orderParts.getTotalPrice());
                                    spareParts.setAvailabilityStock(spareParts.getAvailabilityStock()-quantity);
                                    userRepository.save(user);
                                    orderPartsRepository.save(orderParts);
                                    sparePartsRepository.save(spareParts);


                                }else throw new ApiExcption("admin not found or not login") ;


                            }else throw new ApiExcption("balance is less than spar part price") ;
                        }else throw new ApiExcption("Quantity is larger than stock") ;

                    }else throw new ApiExcption("sold out") ;

                }else throw new ApiExcption("spare parts is not found") ;

            }else throw new ApiExcption("user not logged in") ;

        }else throw new  ApiExcption("user not found") ;
    }


    public void retrieveParts(Integer adminId , Integer quantity, Integer orderid) {
        OrderParts orderParts = orderPartsRepository.findOrderPartsById(orderid);
        Admin admin = adminRepository.findAdminById(adminId);
        User user = userRepository.findUserById(orderParts.getUserId());
        SpareParts spareParts = sparePartsRepository.findSparePartsById(orderParts.getSparePartId());
        orderParts.setTotalPrice(orderParts.getTotalPrice()*quantity);

//
//        if (orderParts != null) {
//            if (spareParts != null) {
////                if (user != null) {
//                    if (admin != null) {
                        user.setBalance(user.getBalance() + orderParts.getTotalPrice());
                        spareParts.setAvailabilityStock(spareParts.getAvailabilityStock() + quantity);
                        orderParts.setStatus(false);
                        userRepository.save(user);
                        sparePartsRepository.save(spareParts);
                        orderPartsRepository.save(orderParts);
//                    }else throw new ApiExcption("admin not found or not login") ;
//
//                }else throw new ApiExcption("user not found or not login") ;
////            }else throw new ApiExcption("spare part is not found") ;
//        }else throw new ApiExcption("orderParts is not found") ;
    }


    public OrderParts getOrder(Integer orderId) {
        OrderParts orderParts = orderPartsRepository.findOrderPartsById(orderId);
        if (orderParts != null) {
            return orderParts;
        }
        throw new ApiExcption("orderParts is not found") ;
    }

    public List<OrderParts> getOrderByStatus(Boolean status) {
        List<OrderParts> list = orderPartsRepository.findOrderPartsByStatus(status);
        if (list != null) {
            return list;
        }
        throw new ApiExcption("orderParts is not found") ;
    }







}
