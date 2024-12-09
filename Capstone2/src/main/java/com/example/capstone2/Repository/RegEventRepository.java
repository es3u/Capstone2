package com.example.capstone2.Repository;

import com.example.capstone2.Model.RegEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegEventRepository extends JpaRepository<RegEvent, Integer> {

    RegEvent findRegEventById(Integer id);
}
