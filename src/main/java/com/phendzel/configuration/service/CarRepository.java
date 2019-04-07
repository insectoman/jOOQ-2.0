package com.phendzel.configuration.service;

import com.phendzel.configuration.dto.CarDTO;
import com.phendzel.public_.tables.records.CarRecord;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.phendzel.public_.Tables.CAR;
import static com.phendzel.public_.Tables.ORDER;

@Repository
public class CarRepository {

    private final DSLContext create;

    public CarRepository(DSLContext create) {
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

    public CarRecord getOneById(Long id) {
        return create.selectFrom(CAR)
                .where(CAR.ID.eq(id))
                .fetchOne();
    }

    public CarDTO getBrandOfTheCarById(Long id) {
        return create.selectFrom(CAR)
                .where(CAR.ID.eq(id))
                .fetchOne(carRecord -> new CarDTO(carRecord.getBrand()));

    }

    public int updateCarBrand(String newBrand, Long id) {
        return create.update(CAR)
                .set(CAR.BRAND, newBrand)
                .where(CAR.ID.eq(id))
                .execute();
    }

    public int deleteById(Long id) {
        return create.delete(CAR)
                .where(CAR.ID.eq(id))
                .execute();
    }

    public int saveNewCars(CarDTO carDTO) {
        return create.insertInto(CAR, CAR.BRAND, CAR.MODEL_YEAR)
                .values(carDTO.getBrand(), carDTO.getModelYear())
                .execute();
    }

    public int[] saveNewCars(List<CarRecord> carRecords) {
        return create.batchStore(carRecords).execute();
    }
}
