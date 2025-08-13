package com.xworkz.exhibition.service;

import com.xworkz.exhibition.dto.ArtDTO;

import java.util.List;

public interface ArtService {
    boolean save(ArtDTO dto);

    List<ArtDTO> getAllArtworks();
    ArtDTO findByID(Integer id);
}
