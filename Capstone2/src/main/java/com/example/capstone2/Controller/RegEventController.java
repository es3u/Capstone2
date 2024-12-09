package com.example.capstone2.Controller;

import com.example.capstone2.Model.RegEvent;
import com.example.capstone2.Service.RegEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/regEvent")
@RequiredArgsConstructor
public class RegEventController {
    private final RegEventService regEventService;

    @GetMapping("/getAllRegEvents")
    public ResponseEntity getAllRegEvents(){
        return ResponseEntity.ok(regEventService.getAllRegEvents());
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody@Valid RegEvent regEvent , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldErrors().get(0).getDefaultMessage());
        }
        regEventService.registration(regEvent);
        return ResponseEntity.ok().body("registration successful");
    }


}
