package com.phendzel;

import com.phendzel.public_.tables.records.CarRecord;

import java.util.List;
import java.util.stream.Collectors;

class Mapper {

    static List<CarDTO> mapToDtos(List<CarRecord> carRecords) {
        return carRecords.stream().map(Mapper::mapToDto).collect(Collectors.toList());
    }

    static CarDTO mapToDto(CarRecord record) {
        return CarDTO
                .builder()
                .brand(record.getBrand())
                .modelYear(record.getModelYear())
                .build();
    }

}
