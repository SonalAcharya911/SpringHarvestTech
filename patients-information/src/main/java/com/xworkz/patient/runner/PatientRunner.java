package com.xworkz.patient.runner;

import com.xworkz.patient.entity.PatientEntity;
import com.xworkz.patient.repo.PatientRepo;
import com.xworkz.patient.repo.PatientRepoImpl;
import com.xworkz.patient.service.PatientService;
import com.xworkz.patient.service.PatientServiceImpl;

public class PatientRunner {
    public static void main(String[] args) {

        PatientRepo patientRepo = new PatientRepoImpl();
        PatientService patientService = new PatientServiceImpl(patientRepo);

        PatientEntity entity1 = new PatientEntity(null, "Tony Stark", 48, "Male", "A+", 9998899901L, "Arc Reactor Dependency", "Dr. Banner", 101);
        patientService.save(entity1);

        PatientEntity entity2 = new PatientEntity(null, "Peter Parker", 21, "Male", "O+", 8887766655L, "Spider Bite Mutation", "Dr. Strange", 102);
        patientService.save(entity2);
        PatientEntity entity3 = new PatientEntity(null, "Natasha Romanoff", 35, "Female", "B+", 9776655443L, "Head Trauma", "Dr. Cho", 103);
        patientService.save(entity3);

        PatientEntity entity4 = new PatientEntity(null, "Steve Rogers", 106, "Male", "AB+", 9332211223L, "Cryo Side Effects", "Dr. Erskine", 104);
        patientService.save(entity4);

        PatientEntity entity5 = new PatientEntity(null, "Wanda Maximoff", 30, "Female", "O-", 9665544332L, "Reality Distortion Episodes", "Dr. Strange", 105);
        patientService.save(entity5);


        PatientEntity found = patientService.findByName("Tony Stark");
        System.out.println("Found by name: " + found);


        PatientEntity wardPatient = patientService.findByWardNumber(101);
        System.out.println("Patient in ward 101: "+ wardPatient);

        patientService.updateAgeByID(45,1);
        patientService.updateContactByNameAndID(9739257715l,"Steve Rogers",4);
        patientService.updateDoctorByBloodGroupAndSickness("Dr. Bruce Banner","O-","Reality Distortion Episodes");

    }
}
