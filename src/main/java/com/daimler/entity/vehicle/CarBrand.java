package com.daimler.entity.vehicle;

import javax.persistence.*;
import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

@Entity
@SqlResultSetMapping(
        name = "CarBrandMapping",
        entities = @EntityResult(
                entityClass = CarBrand.class,
                fields = {
                        @FieldResult(name = "brand", column = "brand"),
                        @FieldResult(name = "total", column = "TOTAL"),
                        @FieldResult(name = "newCarPrice", column = "NEW_CAR_PRICE"),
                        @FieldResult(name = "avgSellPrice", column = "AVG_SELL_PRICE"),
                }))
public class CarBrand {
    @Id
    private String brand;
    private int total;
    private float newCarPrice;
    private float avgSellPrice;

    @Transient
    private float remainingRate;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getNewCarPrice() {
        return new BigDecimal(newCarPrice).setScale(2, ROUND_UP).floatValue();
    }

    public void setNewCarPrice(float newCarPrice) {
        this.newCarPrice = newCarPrice;
    }

    public float getAvgSellPrice() {
        return new BigDecimal(avgSellPrice).setScale(2, ROUND_UP).floatValue();
    }

    public void setAvgSellPrice(float avgSellPrice) {
        this.avgSellPrice = avgSellPrice;
    }

    public float getRemainingRate() {
        return new BigDecimal(avgSellPrice/newCarPrice).setScale(2, ROUND_UP).floatValue();
    }
}
