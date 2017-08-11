package com.daimler.entity.vehicle;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_UP;

@Entity
@SqlResultSetMapping(
        name = "CarStatisticsMapping",
        entities = @EntityResult(
                entityClass = CarStatistics.class,
                fields = {
                        @FieldResult(name = "id.brand", column = "brand"),
                        @FieldResult(name = "id.roadHaul", column = "ROAD_HAUL"),
                        @FieldResult(name = "total", column = "TOTAL"),
                        @FieldResult(name = "newCarPrice", column = "NEW_CAR_PRICE"),
                        @FieldResult(name = "avgSellPrice", column = "AVG_SELL_PRICE")
                }))
public class CarStatistics {
    @EmbeddedId
    private CarStatisticsID id;
    private int total;
    private float newCarPrice;
    private float avgSellPrice;
    @Transient
    private float remainingRate;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getNewCarPrice() {
        return getScaledFloat(newCarPrice);
    }

    public void setNewCarPrice(float newCarPrice) {
        this.newCarPrice = newCarPrice;
    }

    public float getAvgSellPrice() {
        return getScaledFloat(avgSellPrice);
    }

    public void setAvgSellPrice(float avgSellPrice) {
        this.avgSellPrice = avgSellPrice;
    }


    public float getRemainingRate() {
        return getScaledFloat(remainingRate);
    }

    public void setRemainingRate(float remainingRate) {
        this.remainingRate = remainingRate;
    }

    private float getScaledFloat(float value) {
        return new BigDecimal(value).setScale(2, ROUND_UP).floatValue();
    }

    public CarStatisticsID getId() {
        return id;
    }

    public void setId(CarStatisticsID id) {
        this.id = id;
    }

    @Embeddable
    public static class CarStatisticsID implements Serializable {
        private String brand;
        private String roadHaul;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getRoadHaul() {
            return roadHaul;
        }

        public void setRoadHaul(String roadHaul) {
            this.roadHaul = roadHaul;
        }
    }
}


