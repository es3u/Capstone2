package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotNull(message = "admin id can not be empty ")
    @Column(columnDefinition = "int not null")
    private Integer adminId ;
    @NotNull(message = "event is can not be null")
    @Column(columnDefinition = "int not null")
    private Integer eventId;
    @NotNull(message = "userId can not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId;
    @NotNull(message = "car id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer carId ;
    @Column(columnDefinition = "datetime")
    private LocalDateTime RegDate = LocalDateTime.now();

}
