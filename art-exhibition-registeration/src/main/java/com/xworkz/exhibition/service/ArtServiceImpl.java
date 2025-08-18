package com.xworkz.exhibition.service;

import com.xworkz.exhibition.dto.ArtDTO;
import com.xworkz.exhibition.entity.ArtEntity;
import com.xworkz.exhibition.repo.ArtRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtServiceImpl implements ArtService{
    @Autowired
    private ArtRepository repo;

    public boolean save(ArtDTO dto){
        if(dto!=null){

            System.out.println("dto not null");
            System.out.println("Service: "+dto);
            ArtEntity entity=new ArtEntity();

            entity.setArtistName(dto.getArtistName());
            entity.setArtistContact(dto.getArtistContact());
            entity.setArtistEmail(dto.getArtistEmail());
            entity.setArtworkTitle(dto.getArtworkTitle());
            entity.setPrice(dto.getPrice());
            entity.setLengthInCm(dto.getLengthInCm());
            entity.setWidthInCm(dto.getWidthInCm());

            return repo.save(entity);


        }
        return false;
    }

    @Override
    public List<ArtDTO> getAllArtworks() {
        List<ArtEntity> entityList=repo.getAllArtworks();

        List<ArtDTO> dtoList=entityList.stream().map(entity -> {
            ArtDTO dto=new ArtDTO();
            dto.setArtID(entity.getArtID());
            dto.setArtistName(entity.getArtistName());
            dto.setArtworkTitle(entity.getArtworkTitle());
            dto.setLengthInCm(entity.getLengthInCm());
            dto.setWidthInCm(entity.getWidthInCm());
            dto.setPrice(entity.getPrice());
            dto.setArtistEmail(entity.getArtistEmail());
            dto.setArtistContact(entity.getArtistContact());
            return dto;
        }).collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public ArtDTO findByID(Integer id) {
        System.out.println("running findByID in Service");
        ArtEntity entity=repo.findByID(id);

        ArtDTO dto=new ArtDTO();
        dto.setArtID(entity.getArtID());
        dto.setArtistName(entity.getArtistName());
        dto.setArtworkTitle(entity.getArtworkTitle());
        dto.setLengthInCm(entity.getLengthInCm());
        dto.setWidthInCm(entity.getWidthInCm());
        dto.setPrice(entity.getPrice());
        dto.setArtistEmail(entity.getArtistEmail());
        dto.setArtistContact(entity.getArtistContact());

        return dto;
    }

    @Override
    public String updateArtwork(ArtDTO dto) {
        System.out.println("running updateArtwork in Service");
        ArtEntity entity=new ArtEntity();
        BeanUtils.copyProperties(dto,entity);
        boolean saved=repo.updateArtworkDetails(entity);
        if(saved){
            return "saved updated data";
        }
        return "couldn't save data";
    }

    @Override
    public String deleteArtwork(Integer id) {
        System.out.println("running deleteArtwork in Service");
        boolean isDeleted=repo.deleteArtworktByID(id);
        System.out.println("isDeleted: "+isDeleted);
        if(isDeleted){
            return "deleted data successfully";
        }
        return "couldn't delete data";
    }
}
