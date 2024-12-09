package com.example.capstone2.Repository;

import com.example.capstone2.Model.SparePartsSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartsSupplierRepository extends JpaRepository<SparePartsSupplier,Integer> {

    SparePartsSupplier findSparePartsSupplierById(Integer id);


    SparePartsSupplier findSparePartsSupplierByUserNameAndPassword(String username, String password);
}
