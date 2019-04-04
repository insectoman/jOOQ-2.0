package com.phendzel.configuration.service;

import com.jooq.example.public_.tables.records.CarRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jooq.example.public_.Tables.CAR;
import static com.jooq.example.public_.Tables.ORDER;

@Service
public class CarService {

    private final DSLContext create;

    public CarService(DSLContext create) {
        this.create = create;
    }

    public List<CarRecord> getAllFixedCars() {
        return create.select()
                .from(CAR)
                .leftJoin(ORDER).on(ORDER.CAR_ID.eq(CAR.ID))
                .where(ORDER.FINISHED.isTrue())
                .fetchInto(CarRecord.class);
    }

    public List<CarRecord> getAllFixedCarsOnKey() {
        return create.select()
                .from(CAR)
                .leftJoin(ORDER).onKey()
                .where(ORDER.FINISHED.isTrue())
                .fetchInto(CarRecord.class);
    }

}
