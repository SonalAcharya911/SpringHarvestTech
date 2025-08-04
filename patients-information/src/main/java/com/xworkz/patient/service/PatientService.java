package com.xworkz.patient.service;

import com.xworkz.patient.entity.PatientEntity;

public interface PatientService {
    boolean save(PatientEntity entity);

    boolean deletePatient(int id);

    boolean updatePatientContact(int id, Long contact);

    PatientEntity findByID(int id);

    PatientEntity findByName(String name);

    PatientEntity findByWardNumber(Integer wardNo);
}
