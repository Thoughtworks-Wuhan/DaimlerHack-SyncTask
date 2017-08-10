package com.daimler.entity.vehicle;

import com.daimler.controllers.model.Detail;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    private String brand;

    @Column(name = "ROAD_HAUL")
    private float roadHaul;

    @Column(name = "USED_MONTHS")
    private int usedMonths;

    @Column(name = "NEW_CAR_PRICE")
    private float newCarPrice;

    @Column(name = "SELL_PRICE")
    private float sellPrice;

    @Column(name = "GEARBOX_TYPE")
    private String gearboxType;

    public Car() {}

    public Car(Detail detail) {
        this.brand = detail.title;
        this.roadHaul = Math.round(Float.parseFloat(detail.roadHaul)*2.0f)/2.0f;
        this.usedMonths = detail.getUsedMonth();
        this.newCarPrice = Float.parseFloat(detail.newPrice != null ? detail.newPrice : "0");
        this.sellPrice = Float.parseFloat(detail.price != null ? detail.price : "0");
        this.gearboxType = detail.gearbox;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getRoadHaul() {
        return roadHaul;
    }

    public void setRoadHaul(int roadHaul) {
        this.roadHaul = roadHaul;
    }

    public int getUsedMonths() {
        return usedMonths;
    }

    public void setUsedMonths(int usedMonths) {
        this.usedMonths = usedMonths;
    }

    public float getNewCarPrice() {
        return newCarPrice;
    }

    public void setNewCarPrice(float newCarPrice) {
        this.newCarPrice = newCarPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(String gearboxType) {
        this.gearboxType = gearboxType;
    }
}