package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "buyer id can not be empty")
    @Column(columnDefinition = "int ")
    private Integer buyerID ;
    @NotNull(message = "SellerID  can not be empty")
    @Column(columnDefinition = "int ")
    private Integer sellerID ;
    @NotNull(message = "car id can not be empty")
    @Column(columnDefinition = "int ")
    private Integer carId ;
    @Column(columnDefinition = "datetime")
    private LocalDateTime TransactionDate = LocalDateTime.now()  ;
    @Column(columnDefinition = "double")
    private Double price ;
    @NotEmpty(message = "type of transaction is empty")
    @Column(columnDefinition = "varchar(30) ")
    @Pattern(regexp = "^(Instant sale)$")
    private String transactionType ;

    @Column(columnDefinition = "boolean")
    private Boolean status = false ;


}
