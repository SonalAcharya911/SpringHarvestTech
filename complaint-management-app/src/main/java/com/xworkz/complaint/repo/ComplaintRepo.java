

package com.xworkz.complaint.repo;

import com.xworkz.complaint.entity.ComplaintEntity;

import java.util.List;

public interface ComplaintRepo {
    boolean save(ComplaintEntity entity);

    List<ComplaintEntity> getAllComplaints();

    ComplaintEntity findByID(Integer id);

    boolean updateComplaintDetails(ComplaintEntity entity);
}
