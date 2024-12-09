package com.example.capstone2.Controller;

import com.example.capstone2.ApiResponse.ApiExcption;
import com.example.capstone2.Model.SparePartsSupplier;
import com.example.capstone2.Repository.SparePartsSupplierRepository;
import com.example.capstone2.Service.SparePartsSupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SparePartsSupplierService sparePartsSupplierService;

    @GetMapping("/getAll")
    public ResponseEntity getAllSparePartsSuppliers() {
         return ResponseEntity.ok().body(sparePartsSupplierService.getAllSparePartsSupplier());
    }

    @PostMapping("/add")
    public ResponseEntity addSparePartsSupplier(@RequestBody@Valid SparePartsSupplier sparePartsSupplier , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        sparePartsSupplierService.AddSparePartsSupplier(sparePartsSupplier);
        return ResponseEntity.ok().body("sparePartsSupplier added successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateSparePartsSupplier(@PathVariable Integer id ,@RequestBody@Valid SparePartsSupplier sparePartsSupplier , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
       sparePartsSupplierService.updateSparePartsSupplier(id,sparePartsSupplier);
       return ResponseEntity.ok().body("sparePartsSupplier updated successfully");

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSparePartsSupplier(@PathVariable Integer id) {
       sparePartsSupplierService.deleteSparePartsSupplier(id);
       return ResponseEntity.ok().body("sparePartsSupplier deleted successfully");
    }
    @PutMapping("/login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username,@PathVariable String password){
        sparePartsSupplierService.login(username,password);
        return ResponseEntity.ok().body("login successfully");
    }


}
