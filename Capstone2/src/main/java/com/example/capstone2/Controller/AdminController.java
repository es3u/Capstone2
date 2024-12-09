package com.example.capstone2.Controller;

import com.example.capstone2.Model.Admin;
import com.example.capstone2.Service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/getAllAdmins")
    public ResponseEntity getAllAdmins(){
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody@Valid Admin admin , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        adminService.save(admin);
        return ResponseEntity.ok().body("admin saved");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id , @RequestBody@Valid Admin admin, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        adminService.update(id, admin);
        return ResponseEntity.ok().body("admin updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        adminService.delete(id);
        return ResponseEntity.ok().body("admin deleted");
    }

    @PostMapping("/login/{username}/{password}")
    public ResponseEntity login(@PathVariable String username,@PathVariable String password){
        adminService.login(username, password);
        return ResponseEntity.ok().body("admin logged in");
    }




}
