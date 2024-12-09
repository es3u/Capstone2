package com.example.capstone2.Controller;

import com.example.capstone2.Model.User;
import com.example.capstone2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
       return ResponseEntity.ok().body( userService.getAllUsers());
    }

    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody@Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        userService.SaveUser(user);
        return ResponseEntity.ok().body("added user successfully");
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id ,@RequestBody@Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        userService.updateUser(id,user);
        return ResponseEntity.ok().body("updated user successfully");
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body("deleted user successfully");
    }

    @PutMapping("/login/{id}/{username}/{password}")
    public ResponseEntity login(@PathVariable Integer id , @PathVariable String username,@PathVariable String password){
        Boolean resulte = userService.Login(id ,username,password);
        if(resulte){
            return ResponseEntity.ok().body("login successfully");
        }
        return ResponseEntity.badRequest().body("login failed");

    }

    @GetMapping("/myCars/{id}")
    public ResponseEntity getMyCars(@PathVariable Integer id){
        List list = userService.myCars(id);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/getAllRegistrations/{eventName}")
    public ResponseEntity getAllRegistrations(@PathVariable String eventName) {
        return ResponseEntity.ok().body(userService.getAllRegistrations(eventName));
    }









}
