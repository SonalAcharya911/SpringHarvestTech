package com.xworkz.tracker.service;

import com.xworkz.tracker.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    boolean save(ItemDTO dto);

    List<ItemDTO> getAllItems();

    ItemDTO findByID(Integer id);
}
