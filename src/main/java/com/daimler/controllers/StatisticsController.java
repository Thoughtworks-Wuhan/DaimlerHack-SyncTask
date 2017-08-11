package com.daimler.controllers;

import com.daimler.entity.vehicle.CarBrand;
import com.daimler.entity.vehicle.CarStatistics;
import com.daimler.entity.vehicle.StatisticsMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class StatisticsController {

    @Autowired
    private StatisticsMethods statisticsMethods;

    @RequestMapping("/statistics/vehicle")
    public @ResponseBody Map getStatisticsByBrand(@RequestParam(name="brand", required=false, defaultValue = "奔驰") String brand) {
        Map statistics = new HashMap<String, List<CarStatistics>>();
        List<CarBrand> brands = statisticsMethods.findBrandNames(brand);
        for(CarBrand carBrand : brands){
            List<CarStatistics> result = statisticsMethods.findCarStatisticsByBrandName(carBrand.getBrand());
            result.stream().map( item -> {
                item.setRemainingRate(item.getAvgSellPrice()/item.getNewCarPrice());
                return item;
            }).collect(Collectors.toList());
            statistics.put(carBrand.getBrand(), result);
        }
        return statistics;
    }

    @RequestMapping("/statistics/vehicle/hottest")
    public @ResponseBody List getHotestCars(@RequestParam(name="brand", required=false, defaultValue = "奔驰") String brand) {
        return statisticsMethods.findBrandNames(brand);
    }
}
