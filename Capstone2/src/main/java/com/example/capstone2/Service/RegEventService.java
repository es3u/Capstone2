package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.*;
import com.example.capstone2.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegEventService {

    private final RegEventRepository regEventRepository;
    private final EventRepository eventRepository;
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public List<RegEvent> getAllRegEvents() {
        return regEventRepository.findAll();
    }

    ////////////يحتاج لها ترتيب في الشروطInteger adminId ,Integer userId ,Integer carId, Integer eventId
    public void registration(RegEvent regEvent) {
        Admin admin = adminRepository.findAdminById(regEvent.getAdminId());
        Car car = carRepository.findCarByIdAndUserId(regEvent.getCarId(),regEvent.getUserId());
        User user = userRepository.findUserById(regEvent.getUserId());
        Event event = eventRepository.findEventById(regEvent.getEventId());

        if (admin!=null && admin.getLoggedin()){
            if (user != null && user.getLoggedin()){
                if (car!=null){
                    if (event!=null){
                        event.setCapacity(event.getCapacity()-1);
                        user.setEventReg(event.getEventName());
                         userRepository.save(user);
                        regEventRepository.save(regEvent);
                    }else throw new ApiExcption("event is not found") ;

                }else throw new ApiExcption("car is not found") ;

            }else throw new ApiExcption("user is not found or not logged in") ;

        }else throw new ApiExcption("admin is not found or not logged in") ;

        }





}
