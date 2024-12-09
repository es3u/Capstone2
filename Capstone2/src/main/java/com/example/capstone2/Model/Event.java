package com.example.capstone2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "event name can not be null")
    @Column(unique = true, columnDefinition = "varchar(15) not null")
    @Size(max = 15)
    private String eventName;
//    @NotEmpty(message = "date can not be empty")
    @Column(columnDefinition = "date")
    @FutureOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventDate;
    @NotEmpty(message = "location can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String eventLocation;
    @NotEmpty(message = "event Description can not be empty")
    @Column(columnDefinition = "varchar(200) not null")
    @Size(max = 200)
    private String eventDescription;
    @NotEmpty(message = "event type can not be empty")
    @Column(columnDefinition = "varchar(15) not null")
    @Size(max = 15)
    private String eventType;
//    @Column(columnDefinition = "int")
//    private Integer userId ;
//    @Column(columnDefinition = "int")
//    private Integer carId ;
    @NotNull(message = "admin id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer adminId ;
    @NotNull(message = "capacity can not be null")
    @Column(columnDefinition = "int not null")
    @Positive
    private Integer capacity;


}
