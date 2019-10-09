package com.phendzel;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CarController {

    private final CarRepository carRepository;

    @GetMapping("cars/fixed")
    public ResponseEntity getAllFixedCars() {
        List<CarDTO> carDtos = CarMapper.mapToDtos(carRepository.getAllFixedCarsOnKey());
        return ResponseEntity.ok(carDtos);
    }

}
