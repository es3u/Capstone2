package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.Car;
import com.example.capstone2.Model.User;
import com.example.capstone2.Repository.CarRepository;
import com.example.capstone2.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void SaveUser(User user) {
         userRepository.save(user);
    }

    public void updateUser(Integer id , User user) {
        User user1 = userRepository.findUserById(id);

        if(user1 != null) {
            user1.setUsername(user.getUsername());
            user1.setPassword(user.getPassword());
            user1.setEmail(user.getEmail());
            user1.setPhone(user.getPhone());
            user1.setAddress(user.getAddress());
            userRepository.save(user1);
        }
        throw new ApiExcption("user not found");
    }



    public void deleteUser(Integer id) {
        User user = userRepository.findUserById(id);

        if (user != null) {
            userRepository.delete(user);
        }

        throw new ApiExcption("user not found");

    }


    public Boolean Login(Integer id , String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username, password);
        if(user.getId().equals(id)) {
            user.setLoggedin(true);
            userRepository.save(user);
            return true;
        }
        throw new ApiExcption("user not logged in");
    }

    public List<Car> myCars(Integer id) {
        List<Car> mycars = carRepository.findCarByUserId(id);
        if(mycars != null) {
            return mycars;
        }
        throw new ApiExcption("You do not have any added cars.");

    }

    public List<User> getAllRegistrations(String eventName) {
        List<User> users = userRepository.findUserByEventReg(eventName);
        if(users.isEmpty()) {
            throw new ApiExcption("user not found");
        }
        return users;
    }










}
