package com.xworkz.complaint.service;

import com.xworkz.complaint.dto.ComplaintDTO;
import com.xworkz.complaint.entity.ComplaintEntity;
import com.xworkz.complaint.repo.ComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComplaintServiceImpl implements ComplaintService{
    @Autowired
    private ComplaintRepo repo;
    @Override
    public boolean save(ComplaintDTO dto) {
        if(dto!=null){
            System.out.println("Service: "+dto);
            ComplaintEntity entity=new ComplaintEntity();
            entity.setComplainantName(dto.getComplainantName());
            entity.setEmail(dto.getEmail());
            entity.setCategory(dto.getCategory());
            entity.setContact(dto.getContact());
            entity.setDescription(dto.getDescription());
            entity.setLocation(dto.getLocation());

            boolean saved= repo.save(entity);
            return true;
        }
        return false;
    }

    @Override
    public List<ComplaintDTO> getAllComplaints() {
        System.out.println("running getAllComplaints in ServiceImpl");
        List<ComplaintEntity> entityList=repo.getAllComplaints();

        List<ComplaintDTO> dtoList=entityList.stream().map(entity -> {
            ComplaintDTO dto=new ComplaintDTO();
            dto.setComplaintID(entity.getComplaintID());
            dto.setComplainantName(entity.getComplainantName());
            dto.setEmail(entity.getEmail());
            dto.setContact(entity.getContact());
            dto.setCategory(entity.getCategory());
            dto.setDescription(entity.getDescription());
            dto.setLocation(entity.getLocation());
            return dto;
        }).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public ComplaintDTO findByID(Integer id) {
        System.out.println("running findByID in ComplaintServiceImpl...");
        ComplaintDTO dto=null;
        if(id!=null){
            ComplaintEntity entity=repo.findByID(id);
            dto.setComplaintID(entity.getComplaintID());
            dto.setComplainantName(entity.getComplainantName());
            dto.setCategory(entity.getCategory());
            dto.setLocation(entity.getLocation());
            dto.setEmail(entity.getEmail());
            dto.setDescription(entity.getDescription());
            dto.setContact(entity.getContact());

            return dto;
        }
        return null;
    }
}
