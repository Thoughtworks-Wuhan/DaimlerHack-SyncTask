package com.daimler.entity.vehicle;

import java.util.List;
import java.util.Map;

public interface StatisticsMethods {
    List<CarStatistics> findCarStatisticsByBrandName(String carTitle);

    List<CarBrand> findBrandNames(String brand);
}
