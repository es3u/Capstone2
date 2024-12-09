package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bidding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

    @NotNull(message = "bidder id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer bidder ;


//    @NotNull(message = "seller id can not be null")
    @Column(columnDefinition = "int")
    private Integer seller;
    @NotNull(message = "car id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer carId ;
    @Column(columnDefinition = "datetime")
    private LocalDateTime startBidding = LocalDateTime.now();

    @Column(columnDefinition = "int ")
    private Double price;
    @Column(columnDefinition = "boolean")
    private Boolean success = false ;
//    @NotNull(message = "end time can not br empty")
//    @Column(columnDefinition = "datetime not null")
//    private LocalDateTime endBidding;


}
