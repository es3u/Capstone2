package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.Admin;
import com.example.capstone2.Model.Car;
import com.example.capstone2.Model.Event;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.AdminRepository;
import com.example.capstone2.Repository.CarRepository;
import com.example.capstone2.Repository.EventRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;
    private final AdminRepository adminRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public void addEvent(Integer adminId,Event event) {
        Admin admin = adminRepository.findAdminById(adminId);

        if (admin == null) {
            throw new ApiExcption("Admin not found");
        }
        if (admin.getLoggedin()){
            eventRepository.save(event);
        }else
            throw new ApiExcption("Admin not logged in");

    }

    public void updateEvent(Integer id ,Event event) {
        Event event1 = eventRepository.findEventById(id);

        if(event1 != null) {
            event1.setEventDate(event.getEventDate());
            event1.setEventDescription(event.getEventDescription());
            event1.setEventLocation(event.getEventLocation());
            event1.setEventName(event.getEventName());
            event1.setEventType(event.getEventType());
            eventRepository.save(event1);
        }
        throw new ApiExcption("event not found");
    }

    public void deleteEvent(Integer id) {
        Event event = eventRepository.findEventById(id);

        if(event != null) {
            eventRepository.delete(event);
        }

        throw new ApiExcption("event not found");
    }


//
//    public List<User> getAllRegistrations(String eventName) {
//        List<User> users = userRepository.findUserByEventReg(eventName);
//        if(users.isEmpty()) {
//            throw new ApiExcption("user not found");
//        }
//        return users;
//    }





}
