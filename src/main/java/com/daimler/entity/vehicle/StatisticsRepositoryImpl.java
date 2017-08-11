package com.daimler.entity.vehicle;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class StatisticsRepositoryImpl implements StatisticsMethods {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<CarStatistics> findCarStatisticsByBrandName(String carTitle) {
        Query query = em.createNativeQuery(
                "select count(*) as Total, brand, ROAD_HAUL, AVG(SELL_PRICE) as AVG_SELL_PRICE, AVG(NEW_CAR_PRICE) as NEW_CAR_PRICE from lanedb.car where brand = ?1 group by ROAD_HAUL order by ROAD_HAUL desc",
        "CarStatisticsMapping");
        query.setParameter(1, carTitle);

        return query.getResultList();
    }

    @Override
    public List<CarBrand> findBrandNames(String brand) {
        Query query = em.createNativeQuery(
                "select brand, AVG(NEW_CAR_PRICE) as NEW_CAR_PRICE, AVG(SELL_PRICE) as AVG_SELL_PRICE, count(*) as Total from lanedb.car where brand like CONCAT('%', ?1, '%') group by brand order by Total desc", "CarBrandMapping");
        query.setParameter(1, brand);
        return query.getResultList().subList(0, 10);
    }
}
