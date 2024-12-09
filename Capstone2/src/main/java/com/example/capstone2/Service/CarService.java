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
public class CarService {
    private final CarRepository carRepository;
    private final UserRepository userRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }


    public void addCar(Integer id,Car car) {
        User user = userRepository.findUserById(id);
        if (user != null) {
            if (user.getLoggedin()) {
                car.setUserId(user.getId());
                carRepository.save(car);
            }else{
            throw new ApiExcption("user not logged in");}
        }else{
            throw new ApiExcption("user not found");}



    }


    public void updateCar(Integer id , Car car) {
        Car car1 = carRepository.findCarById(id);

        if(car1 != null) {
            car1.setMake(car.getMake());
            car1.setModel(car.getModel());
            car1.setYear(car.getYear());
            car1.setKilometers(car.getKilometers());
            carRepository.save(car1);
        }
        throw new ApiExcption("Car not found");
    }

    public void deleteCar(Integer id) {
        Car car = carRepository.findCarById(id);
        if(car != null) {
            carRepository.delete(car);
        }

        throw new ApiExcption("Car not found");
    }





}
