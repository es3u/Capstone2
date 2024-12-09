package com.example.capstone2.Repository;

import com.example.capstone2.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findCarById(Integer id);

    List<Car> findCarByUserId(Integer userId);


    Car findCarByIdAndUserId(Integer id, Integer userId);


}
