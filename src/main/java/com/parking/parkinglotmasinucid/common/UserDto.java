package com.parking.parkinglotmasinucid.common;

import org.example.parkinglot.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class UserDto {
    Long id;
    String username;
    String email;
    String password;
    List<Car> cars = new ArrayList<>();


    public UserDto() {
    }

    public UserDto(Long id, String username, String email, String password, List<Car> cars) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cars = cars;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Car> getCars() {
        return cars;
    }


}
