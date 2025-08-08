package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDTO;
import org.springframework.stereotype.Service;


public interface TourismService {
    boolean saveTourism(TourismDTO dto);
}
