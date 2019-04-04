package com.phendzel.configuration.controller;

import com.phendzel.configuration.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("cars/fixed")
    public void getAllFixedCars() {
        carService.getAllFixedCars();
    }

}
