package com.phendzel;

import com.phendzel.public_.tables.records.CarRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.phendzel.public_.Tables.*;
import static org.jooq.impl.DSL.count;

@AllArgsConstructor
@Repository
class DbRepository {

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

    List<MechanicWithNumberOfFixedCarsDTO> getMechanicsWhichFixedMoreThan2CarsIn2016(){
        return create.select(MECHANIC.NAME, MECHANIC.SURNAME, count())
                .from(MECHANIC)
                .leftJoin(MECHANIC_ORDER).onKey()
                .leftJoin(ORDER).onKey()
                .leftJoin(CAR).onKey()
                .where(CAR.BRAND.eq("Audi"))
                .and(ORDER.FINISH_DATE.gt(LocalDate.of(2016, 1, 1)))
                .groupBy(MECHANIC.NAME, MECHANIC.SURNAME)
                .having(count().greaterThan(1))
                .orderBy(MECHANIC.SURNAME)
                .fetchInto(MechanicWithNumberOfFixedCarsDTO.class);
    }

}
