package com.xworkz.exhibition.repo;

import com.xworkz.exhibition.entity.ArtEntity;

import java.util.List;

public interface ArtRepository {
    boolean save(ArtEntity entity);

    List<ArtEntity> getAllArtworks();

}
