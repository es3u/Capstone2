package com.example.capstone2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @NotEmpty(message = "user name can not be empty")
    @Column(unique = true , columnDefinition = "varchar(15) not null")
    @Size(min = 5, max = 15)
    private String username;
    @NotEmpty(message = "password can not be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must be at least 8 characters long, include at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    @Column(columnDefinition = "varchar(15) not null")
    @Size(min = 5, max = 15)
    private String password;

    @Column(columnDefinition = "varchar(50)")
    @Size(min = 5, max = 50)
    private String address;
    @NotEmpty(message = "phone number can not empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Size(min = 10, max = 10)
    private String phone;
    @Email
    @Column(columnDefinition = "varchar(50)")
    @Size(max = 50)
    private String email;

    @Column(columnDefinition = "boolean")
    private Boolean loggedin = false;
    @Column(columnDefinition = "varchar(20)")
    private String eventReg = null ;
//    @NotNull(message = "balance can not null")
    @Column(columnDefinition = "double ")
    private Double balance ;


//    @OneToMany
//    private ArrayList<Car> myCars = new ArrayList<>();
    public void setLoggedin(Boolean loggedin) {
        this.loggedin = loggedin;
    }


//    public void setMyCars(Car car) {
//
//        myCars.add(car);
//    }
}
