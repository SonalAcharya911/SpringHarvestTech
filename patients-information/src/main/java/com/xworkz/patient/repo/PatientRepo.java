package com.xworkz.patient.repo;

import com.xworkz.patient.entity.PatientEntity;

public interface PatientRepo {
    boolean save(PatientEntity entity);

    boolean deletePatient(int id);

    boolean updatePatientContact(int id, Long contact);

    PatientEntity findByID(int id);

    PatientEntity findByName(String name);

    PatientEntity findByWardNumber(Integer wardNo);
}
