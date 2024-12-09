package com.example.capstone2.Controller;

import com.example.capstone2.Model.SpareParts;
import com.example.capstone2.Service.SparePartsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/spareParts")
@RequiredArgsConstructor
public class SparePartsController {
    private final SparePartsService sparePartsService;

    @GetMapping("/findAllSpareParts")
    public ResponseEntity findAllSpareParts() {
        return ResponseEntity.ok().body(sparePartsService.getAllSpareParts());
    }

    @PostMapping("/addSpareParts")
    public ResponseEntity addSpareParts(@RequestBody@Valid SpareParts spareParts , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        sparePartsService.addSpareParts(spareParts);
        return ResponseEntity.ok().body("added spare parts successfully");
    }
    @PutMapping("/updateSpareParts/{id}")
    public ResponseEntity updateSpareParts(@PathVariable Integer id ,@RequestBody @Valid SpareParts spareParts , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        sparePartsService.updateSpareParts(id,spareParts);
        return ResponseEntity.ok().body("updated spare parts successfully");
    }
    @DeleteMapping("/deleteSpareParts/{id}")
    public ResponseEntity deleteSpareParts(@PathVariable Integer id) {
        sparePartsService.deleteSpareParts(id);
        return ResponseEntity.ok().body("deleted spare parts successfully");
    }

}
