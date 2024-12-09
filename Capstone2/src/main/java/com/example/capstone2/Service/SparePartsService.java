package com.example.capstone2.Service;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.SpareParts;
import com.example.capstone2.Model.SparePartsSupplier;
import com.example.capstone2.Repository.SparePartsRepository;
import com.example.capstone2.Repository.SparePartsSupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SparePartsService {
    private final SparePartsRepository sparePartsRepository;
    private final SparePartsSupplierRepository sparePartsSupplierRepository;


    public List<SpareParts> getAllSpareParts() {return sparePartsRepository.findAll();
    }

    public void addSpareParts(SpareParts spareParts) {
        SparePartsSupplier supplier = sparePartsSupplierRepository.findSparePartsSupplierById(spareParts.getSupplierId());

        if(supplier != null ) {
            if (supplier.getLogedin()){
                sparePartsRepository.save(spareParts);
            }else throw new ApiExcption("supplier noy login");

        }else throw new ApiExcption("supplier not found");
    }

    public void updateSpareParts(Integer id ,SpareParts spareParts) {
        SpareParts spareParts1 = sparePartsRepository.findSparePartsById(id);

        if(spareParts1 != null) {
            spareParts1.setPartDescription(spareParts.getPartDescription());
            spareParts1.setPartPrice(spareParts.getPartPrice());
            spareParts1.setPartName(spareParts.getPartName());
            spareParts1.setAvailabilityStock(spareParts.getAvailabilityStock());
            sparePartsRepository.save(spareParts1);
        }
        throw new ApiExcption("SpareParts not found");
    }

    public void deleteSpareParts(Integer id) {
        SpareParts spareParts = sparePartsRepository.findSparePartsById(id);
        if(spareParts != null) {
            sparePartsRepository.delete(spareParts);
        }
        throw new ApiExcption("SpareParts not found");
    }




}
