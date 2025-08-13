package com.xworkz.tracker.service;

import com.xworkz.tracker.dto.ItemDTO;
import com.xworkz.tracker.entity.ItemEntity;
import com.xworkz.tracker.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository repository;

    @Override
    public boolean save(ItemDTO dto) {
        if(dto!=null){
            System.out.println("dto is not null in service");
            System.out.println("Service: "+dto);
            ItemEntity entity=new ItemEntity();

            entity.setContact(dto.getContact());
            entity.setItemName(dto.getItemName());
            entity.setEmail(dto.getEmail());
            entity.setItemDescription(dto.getItemDescription());
            entity.setLocation(dto.getLocation());
            entity.setHolderName(dto.getHolderName());
            entity.setLostOrFound(dto.getLostOrFound());
            entity.setLostOrFoundDate(dto.getLostOrFoundDate());



            return repository.save(entity);
        }
        return false;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemEntity> entityList=repository.getAllItems();

        List<ItemDTO> dtoList=entityList.stream().map(e->
        {
            ItemDTO dto=new ItemDTO();
            dto.setHolderName(e.getHolderName());
            dto.setItemName(e.getItemName());
            dto.setItemDescription(e.getItemDescription());
            dto.setLostOrFound(e.getLostOrFound());
            dto.setLocation(e.getLocation());
            dto.setLostOrFoundDate(e.getLostOrFoundDate());
            dto.setEmail(e.getEmail());
            dto.setContact(e.getContact());
            dto.setItemID(e.getItemID());
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public ItemDTO findByID(Integer id) {
        System.out.println("running findByID in Service...");

        ItemEntity entity= repository.findByID(id);
        ItemDTO dto=new ItemDTO();
        dto.setHolderName(entity.getHolderName());
        dto.setItemName(entity.getItemName());
        dto.setItemDescription(entity.getItemDescription());
        dto.setLostOrFound(entity.getLostOrFound());
        dto.setLocation(entity.getLocation());
        dto.setLostOrFoundDate(entity.getLostOrFoundDate());
        dto.setEmail(entity.getEmail());
        dto.setContact(entity.getContact());
        dto.setItemID(entity.getItemID());

        return dto;
    }
}
