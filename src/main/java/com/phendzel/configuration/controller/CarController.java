package com.phendzel.configuration.controller;

import com.phendzel.configuration.service.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("cars/fixed")
    public void getAllFixedCars() {
        carRepository.getAllFixedCars();
    }

}
