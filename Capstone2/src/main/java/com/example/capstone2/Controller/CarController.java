package com.example.capstone2.Controller;

import com.example.capstone2.Model.Car;
import com.example.capstone2.Repository.UserRepository;
import com.example.capstone2.Service.CarService;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final UserRepository userRepository;
    @GetMapping("/getAllCars")
    public ResponseEntity getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping("/addCar/{id}")
    public ResponseEntity addCar(@PathVariable Integer id,@RequestBody@Valid Car car , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        carService.addCar(id,car);
        return ResponseEntity.ok().body("car added successfully");
    }
@PutMapping("/updateCar/{id}")
    public ResponseEntity updateCar(@PathVariable Integer id , @RequestBody@Valid Car car , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());

        }
        carService.updateCar(id, car);
        return ResponseEntity.ok().body("car updated successfully");
    }
@DeleteMapping("/deleteCar/{id}")
    public ResponseEntity deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return ResponseEntity.ok().body("car deleted successfully");
    }

}
