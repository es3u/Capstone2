package com.example.capstone2.Controller;

import com.example.capstone2.Model.OrderParts;
import com.example.capstone2.Service.OrderPartsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderPartsController {
    private final OrderPartsService orderPartsService;


    @GetMapping("/getAllOrderParts")
    public ResponseEntity getAllOrderParts() {
        return ResponseEntity.ok().body(orderPartsService.getAllOrderParts());
    }

    @PostMapping("/addOrderParts")
    public ResponseEntity addOrderParts(@RequestBody@Valid OrderParts orderParts , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        orderPartsService.addOrderParts(orderParts);
        return ResponseEntity.ok().body("orderParts added successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteOrderParts(@PathVariable Integer id) {
        orderPartsService.deleteOrderParts(id);
        return ResponseEntity.ok().body("orderParts deleted successfully");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateOrderParts(@PathVariable Integer id, @RequestBody OrderParts orderParts ,Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        orderPartsService.updateOrderParts(id, orderParts);
        return ResponseEntity.ok().body("orderParts updated successfully");
    }

    @PostMapping("/buyOfSparePart/{adminId}/{quantity}/{orderid}")
    public ResponseEntity buyOfSparePart(@PathVariable Integer adminId , @PathVariable Integer quantity,@PathVariable Integer orderid){
        orderPartsService.buyOfSparePart(adminId,quantity,orderid);
        return ResponseEntity.ok().body("orderParts buy of spare part successfully");
    }
    @PutMapping("/retrieveParts/{adminId}/{quantity}/{orderId}")
    public ResponseEntity retrieveParts(@PathVariable Integer adminId , @PathVariable Integer orderId ,@PathVariable Integer quantity){
        orderPartsService.retrieveParts(adminId,orderId,quantity);
        return ResponseEntity.ok().body("orderParts retrieved successfully");
    }
    @GetMapping("/getOrder/{orderId}")
    public ResponseEntity getOrder(@PathVariable Integer orderId){
        return ResponseEntity.ok().body(orderPartsService.getOrder(orderId));
    }

    @GetMapping("/getOrderByStatus/{status}")
    public ResponseEntity getOrderByStatus(@PathVariable Boolean status){
        return ResponseEntity.ok().body(orderPartsService.getOrderByStatus(status));
    }




}
