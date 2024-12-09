package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpareParts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "SpareParts name can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Pattern(regexp = "^(engine|wheels|oil)$")
    @Size(max = 20)
    private String partName;


    @NotNull(message = "part price can not be null")
    @Column(columnDefinition = "double not null")
    @Positive
    private Double partPrice;

    @Column(columnDefinition = "int not null ")
    @Positive
    private Integer availabilityStock  ;

    @NotEmpty(message = "description can not be null")
    @Column(columnDefinition = "varchar(200) not null")
    @Size(max = 200)
    private String partDescription;

    //@NotNull(message = "supplier can not be null")
    @Column(columnDefinition = "int")
    private Integer supplierId;

    @Column(columnDefinition = "datetime")
    private LocalDateTime partDate = LocalDateTime.now();

}
