package com.phendzel;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@org.springframework.web.bind.annotation.RestController
public class RestEndpoint {

    private final DbRepository dbRepository;

    @GetMapping("cars/fixed")
    public ResponseEntity getAllFixedCars() {
        List<CarDTO> carDtos = Mapper.mapToDtos(dbRepository.getAllFixedCarsOnKey());
        return ResponseEntity.ok(carDtos);
    }

}
