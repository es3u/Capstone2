package com.example.capstone2.Model;

import com.example.capstone2.Repository.SparePartsSupplierRepository;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SparePartsSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotEmpty(message = "name can not be empty")
    @Column(unique = true , columnDefinition = "varchar(25) not null")
    private String name;

    @NotEmpty(message = "user name can not be empty")
    @Column(unique = true , columnDefinition = "varchar(12) not null")
    @Size(min = 2, max = 12)
    private String userName ;
    @NotEmpty(message = "password can not be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    private String password ;
    @NotEmpty(message = "can not be empty")
    @Column(unique = true, columnDefinition = "varchar(10) not null")
    private String commercial_Register ;
    @NotEmpty(message = "address can not be empty")
    @Column(columnDefinition = "varchar(25) not null")
    private String address ;
    @Column(columnDefinition = "boolean ")
    private Boolean logedin = false ;

}
