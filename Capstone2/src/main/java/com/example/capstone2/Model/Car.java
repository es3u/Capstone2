package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "make can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
  //  @Size(min = 0 , max = 20)
    private String make;

    @NotEmpty(message = "model can not be empty")
    @Column(columnDefinition = "varchar(20) not null")
  //  @Size(min = 0 , max = 20)
    private String model;

    @NotNull(message = "year can not be null")
    @Column(columnDefinition = "int not null")

   // @Size(min = 1980 , max = 2007)
    private Integer year;
    @NotEmpty(message = "color can not be empty")
    @Column(columnDefinition = "varchar(15) not null")
    //@Size(min = 0 , max = 15)
    private String color;
    @NotNull(message = "kilometer can not be null")
    @Column(columnDefinition = ("double not null"))
    private Double kilometers;

    @Column(columnDefinition = "varchar(15)")
    @Pattern(regexp = "^(Good|Medium|Needs maintenance)")
    private String conditionType;

    @Column(columnDefinition = "varchar(20)")
    private String vin ;

//    @Column(columnDefinition = "double ")
//    private Double price ;

//    @NotNull(message = "user id can not be empty")
    @Column(columnDefinition = "int not null")
    private Integer userId;

}
