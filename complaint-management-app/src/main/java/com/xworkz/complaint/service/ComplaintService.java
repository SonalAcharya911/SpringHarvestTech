package com.xworkz.complaint.service;

import com.xworkz.complaint.dto.ComplaintDTO;
import com.xworkz.complaint.entity.ComplaintEntity;

import java.util.List;

public interface ComplaintService {
    boolean save(ComplaintDTO dto);

    List<ComplaintDTO> getAllComplaints();

    ComplaintDTO findByID(Integer id);

    String updateComplaint(ComplaintDTO dto);

    String deleteComplaint(Integer id);
}
