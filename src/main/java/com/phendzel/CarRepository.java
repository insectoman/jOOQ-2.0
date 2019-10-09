package com.phendzel;

import com.phendzel.public_.tables.records.CarRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.phendzel.public_.Tables.CAR;
import static com.phendzel.public_.Tables.ORDER;

@AllArgsConstructor
@Repository
class CarRepository {

    private final DSLContext create;

    List<CarRecord> getAllFixedCars() {
        return create.select()
                .from(CAR)
                .leftJoin(ORDER).on(ORDER.CAR_ID.eq(CAR.ID))
                .where(ORDER.FINISHED.isTrue())
                .fetchInto(CarRecord.class);
    }

    List<CarRecord> getAllFixedCarsOnKey() {
        return create.select()
                .from(CAR)
                .leftJoin(ORDER).onKey()
                .where(ORDER.FINISHED.isTrue())
                .fetchInto(CarRecord.class);
    }

    CarRecord getOneById(Long id) {
        return create.selectFrom(CAR)
                .where(CAR.ID.eq(id))
                .fetchOne();
    }

    CarDTO getBrandOfTheCarById(Long id) {
        return create.selectFrom(CAR)
                .where(CAR.ID.eq(id))
                .fetchOne(carRecord -> new CarDTO(carRecord.getBrand(), carRecord.getModelYear()));
    }

    int updateCarBrand(String newBrand, Long id) {
        return create.update(CAR)
                .set(CAR.BRAND, newBrand)
                .where(CAR.ID.eq(id))
                .execute();
    }

    int deleteById(Long id) {
        return create.delete(CAR)
                .where(CAR.ID.eq(id))
                .execute();
    }

    int saveNewCars(CarDTO carDTO) {
        return create.insertInto(CAR, CAR.BRAND, CAR.MODEL_YEAR)
                .values(carDTO.getBrand(), carDTO.getModelYear())
                .execute();
    }

    int[] saveNewCars(List<CarRecord> carRecords) {
        return create.batchStore(carRecords).execute();
    }

}
