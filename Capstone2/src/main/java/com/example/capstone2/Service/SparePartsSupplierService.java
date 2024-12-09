package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.SparePartsSupplier;
import com.example.capstone2.Repository.SparePartsSupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SparePartsSupplierService {

    private final SparePartsSupplierRepository sparePartsSupplierRepository;

    public List<SparePartsSupplier> getAllSparePartsSupplier(){
        return sparePartsSupplierRepository.findAll();
    }

    public void AddSparePartsSupplier(SparePartsSupplier sparePartsSupplier){
        sparePartsSupplierRepository.save(sparePartsSupplier);
    }

    public void updateSparePartsSupplier(Integer id ,SparePartsSupplier sparePartsSupplier){
        SparePartsSupplier supplier = sparePartsSupplierRepository.findSparePartsSupplierById(id);
        if(supplier != null){
            supplier.setName(sparePartsSupplier.getName());
            supplier.setPassword(sparePartsSupplier.getPassword());
            supplier.setAddress(sparePartsSupplier.getAddress());
            supplier.setUserName(sparePartsSupplier.getUserName());
            supplier.setCommercial_Register(sparePartsSupplier.getCommercial_Register());
            sparePartsSupplierRepository.save(supplier);
        }
        throw new ApiExcption("supplier not found");
    }
    public void deleteSparePartsSupplier(Integer id){
            SparePartsSupplier supplier = sparePartsSupplierRepository.findSparePartsSupplierById(id);
        if(supplier != null){
            sparePartsSupplierRepository.deleteById(id);

        }
        throw new ApiExcption("supplier not found");
    }

    public void login(String username, String password){
        SparePartsSupplier supplier = sparePartsSupplierRepository.findSparePartsSupplierByUserNameAndPassword(username, password);
        if(supplier == null){
            throw new ApiExcption("supplier not found");
        }
        supplier.setLogedin(true);
        sparePartsSupplierRepository.save(supplier);
    }




}
