package com.xworkz.tourism.repository;

import com.xworkz.tourism.entity.TourismEntity;

import java.util.List;

public interface TourismRepo {
    boolean saveTourism(TourismEntity entity);

    List<TourismEntity> fetchAll();

}
