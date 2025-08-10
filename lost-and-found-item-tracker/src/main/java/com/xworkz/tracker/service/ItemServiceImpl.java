package com.xworkz.tracker.service;

import com.xworkz.tracker.dto.ItemDTO;

public class ItemServiceImpl implements ItemService{
    @Override
    public boolean save(ItemDTO dto) {
        if(dto!=null){
            System.out.println("dto is not null in service");
            System.out.println("Service: "+dto);

            return true;
        }
        return false;
    }
}
