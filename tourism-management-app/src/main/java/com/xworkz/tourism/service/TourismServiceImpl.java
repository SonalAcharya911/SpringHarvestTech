package com.xworkz.tourism.service;

import com.xworkz.tourism.dto.TourismDTO;
import com.xworkz.tourism.entity.TourismEntity;
import com.xworkz.tourism.repository.TourismRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourismServiceImpl implements TourismService{
    @Autowired
    TourismRepo repo;
    @Override
    public boolean saveTourism(TourismDTO dto) {
        if(dto!=null){
            System.out.println("dto is not null in service");
            System.out.println("Service: "+dto);

            TourismEntity entity=new TourismEntity();
            entity.setDestination(dto.getDestination());
            entity.setStartPoint(dto.getStartPoint());
            entity.setPackagePrice(dto.getPackagePrice());
            entity.setVehicle(dto.getVehicle());
            entity.setVehicleNumber(dto.getVehicleNumber());
            entity.setNoOfPeople(dto.getNoOfPeople());
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());

            repo.saveTourism(entity);
            return true;
        }
        return false;
    }
}
