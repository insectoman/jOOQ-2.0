package com.phendzel;

public class MechanicWithNumberOfFixedCarsDTO {

    private String name;
    private String surname;
    private Integer numberOfFixedCars;

    public MechanicWithNumberOfFixedCarsDTO(String name, String surname, Integer numberOfFixedCars) {
        this.name = name;
        this.surname = surname;
        this.numberOfFixedCars = numberOfFixedCars;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getNumberOfFixedCars() {
        return numberOfFixedCars;
    }

    public void setNumberOfFixedCars(Integer numberOfFixedCars) {
        this.numberOfFixedCars = numberOfFixedCars;
    }
}
