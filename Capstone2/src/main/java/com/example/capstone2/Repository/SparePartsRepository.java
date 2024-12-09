package com.example.capstone2.Repository;

import com.example.capstone2.Model.SpareParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartsRepository extends JpaRepository<SpareParts, Integer> {
    SpareParts findSparePartsById(Integer id);
}
