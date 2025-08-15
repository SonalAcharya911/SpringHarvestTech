package com.xworkz.tracker.repository;

import com.xworkz.tracker.dto.ItemDTO;
import com.xworkz.tracker.entity.ItemEntity;

import java.util.List;

public interface ItemRepository {
    boolean save(ItemEntity entity);

    List<ItemEntity> getAllItems();

    ItemEntity findByID(Integer id);

    boolean updateItem(ItemEntity entity);
}
