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
public class OrderParts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

//    @NotNull(message = "admin id can not be empty")
//    @Column(columnDefinition = "int")
//    private Integer adminId ;

    @NotNull(message = "supplier can not be null")
    @Column(columnDefinition = "int not null")
    private Integer supplierId ;

    @NotNull(message = "spare part can not be null")
    @Column(columnDefinition = "int not null")
    private Integer sparePartId ;

    @NotNull(message = "user id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer userId ;

    @NotNull(message = "car id can not be null")
    @Column(columnDefinition = "int not null")
    private Integer carId ;

    @Column(columnDefinition = "int ")
    private Double totalPrice ;

    @Column(columnDefinition = "boolean")
    private Boolean status = true ;
    @Column(columnDefinition = "datetime")
    private LocalDateTime orderDate = LocalDateTime.now() ;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId( Integer userId) {
        this.userId = userId;
    }
}
