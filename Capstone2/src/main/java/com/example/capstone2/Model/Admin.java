package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @NotEmpty(message = "name can not be empty")
    @Column(unique = true , columnDefinition = "varchar(20) not null")
    private String name ;
    @NotEmpty(message = "username can not be empty")
    @Column(unique = true , nullable = false , columnDefinition = "varchar(12)")
    private String username;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    @Column(columnDefinition = "varchar(15) not null")
    @Size(min = 5, max = 15)
    private String password;
    @Email
    @Column(unique = true , columnDefinition = "varchar(30)")
    private String email;
    @NotEmpty(message = "phone can not be empty")
    @Column(unique = true , columnDefinition = "varchar(10) not null")
    private String phone;
    @Column(columnDefinition = "boolean")
    private Boolean loggedin = false ;



}
