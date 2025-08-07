package com.xworkz.patient.service;

import com.xworkz.patient.entity.PatientEntity;

import java.util.List;

public interface PatientService {
    boolean save(PatientEntity entity);

    boolean deletePatient(int id);

    boolean updatePatientContact(int id, Long contact);

    PatientEntity findByID(int id);

    PatientEntity findByName(String name);

    PatientEntity findByWardNumber(Integer wardNo);

    int updateDoctorByBloodGroupAndSickness(String doctor,String bloodGroup,String sickness);

    int updateAgeByID(Integer age,Integer id);

    int updateContactByNameAndID(Long contact,String name,Integer id);

    List<Object> getAllPatientNames();

    List<Integer> getAllWardNos();

    List<String[]> getAllPatientsDoctorSickness();
}
