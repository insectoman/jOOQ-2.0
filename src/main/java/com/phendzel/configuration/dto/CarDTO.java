package com.phendzel.configuration.dto;

public class CarDTO {

    private String brand;
    private Integer modelYear;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public CarDTO(String brand) {
        this.brand = brand;
    }

    public CarDTO(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public CarDTO(String brand, Integer modelYear) {
        this.brand = brand;
        this.modelYear = modelYear;
    }
}
