package com.example.capstone2.Controller;

import com.example.capstone2.Model.Transaction;
import com.example.capstone2.Service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/getAllTransactions")
    public ResponseEntity getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
    @PostMapping("/addTransaction/{adminId}")
    public ResponseEntity addTransaction(@PathVariable Integer adminId, Integer buyer , Integer seller  ,@RequestBody@Valid Transaction transaction , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        transactionService.addTransaction( adminId , buyer , seller, transaction);
        return ResponseEntity.ok().body("transaction is added successfully");
    }

    @PutMapping("/updateTransaction/{id}")
    public ResponseEntity updateTransaction(@PathVariable Integer id , @RequestBody@Valid Transaction transaction , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());

        }
        transactionService.updateTransaction(id, transaction);
        return ResponseEntity.ok().body("transaction is updated successfully");
    }

    @DeleteMapping("/deleteTransaction/{id}")
    public ResponseEntity deleteTransaction(@RequestParam Integer id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.ok().body("transaction is deleted successfully");
    }
    @PutMapping("/BuyOfCar/{adminId}/{id}")
    public ResponseEntity BuyOfCar(@PathVariable Integer adminId , @PathVariable Integer id ){
        transactionService.BuyOfCar(adminId,id);
        return ResponseEntity.ok().body("transaction is buy of car successfully");
    }
    @GetMapping("/findByStatus/{status}")
    public ResponseEntity findByStatus(@PathVariable Boolean status){
        return ResponseEntity.ok(transactionService.findByStatus(status));

    }

    @GetMapping("/findTransactionById/{id}")
    public ResponseEntity findTransactionById(@PathVariable Integer id){
        return ResponseEntity.ok(transactionService.findTransactionById(id));
    }

}
