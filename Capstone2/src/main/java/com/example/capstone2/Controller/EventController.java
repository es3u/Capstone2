package com.example.capstone2.Controller;

import com.example.capstone2.Model.Event;
import com.example.capstone2.Service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/event")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping("/findAllEvents")
    public ResponseEntity findAllEvents() {
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }

    @PostMapping("/addEvent/{adminId}")
    public ResponseEntity addEvent(@PathVariable Integer adminId,@RequestBody@Valid Event event , Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        eventService.addEvent(adminId ,event);
        return ResponseEntity.ok().body("added event successfully");
    }
    @PutMapping("/updateEvent/{id}")
    public ResponseEntity updateEvent(@PathVariable Integer id , @RequestBody@Valid Event event ,Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        eventService.updateEvent(id, event);
        return ResponseEntity.ok().body("updated event successfully");
    }

    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity deleteEvent(@PathVariable Integer id , @RequestBody@Valid Event event) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok().body("deleted event successfully");
    }
//    @PostMapping("/registration/{userId}/{carId}/{eventId}")
//    public ResponseEntity registration(@PathVariable Integer userId ,@PathVariable Integer carId ,@PathVariable Integer eventId) {
//        return ResponseEntity.ok().body(eventService.registration(userId,carId, eventId));
//    }





}
