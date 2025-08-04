package com.xworkz.patient.service;

import com.xworkz.patient.entity.PatientEntity;
import com.xworkz.patient.repo.PatientRepo;

public class PatientServiceImpl implements PatientService {

    private PatientRepo patientRepo;

    public PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public boolean save(PatientEntity entity) {
        if (entity != null) {

            if (entity.getName() == null || entity.getName().length() < 3) {
                System.out.println("Invalid name");
                return false;
            }

            if (entity.getAge() == null || entity.getAge() <= 0 || entity.getAge() > 120) {
                System.out.println("Invalid age");
                return false;
            }

            String gender = entity.getGender();
            if (gender == null || !(gender.equalsIgnoreCase("male")
                    || gender.equalsIgnoreCase("female")
                    || gender.equalsIgnoreCase("other"))) {
                System.out.println("Invalid gender");
                return false;
            }

            String bloodGroup = entity.getBloodGroup();
            if (bloodGroup == null || !(bloodGroup.matches("^(A|B|AB|O)[+-]$"))) {
                System.out.println("Invalid blood group");
                return false;
            }

            if (entity.getSickness() == null || entity.getSickness().length() < 3) {
                System.out.println("Invalid sickness description");
                return false;
            }

            if (entity.getPreferredDoctor() == null || entity.getPreferredDoctor().length() < 3) {
                System.out.println("Invalid preferred doctor");
                return false;
            }

            if (entity.getWardNumber() == null || entity.getWardNumber() <= 0) {
                System.out.println("Invalid ward number");
                return false;
            }

            System.out.println("Validation passed. Saving patient...");
            boolean saved = patientRepo.save(entity);
            if (saved) {
                System.out.println("Patient data saved to repository.");
                return true;
            } else {
                System.out.println("Failed to save patient data.");
            }
        }
        return false;
    }

    @Override
    public boolean deletePatient(int id) {
        if (id > 0) {
            boolean deleted = patientRepo.deletePatient(id);
            if (deleted) {
                System.out.println("Patient data deleted.");
                return true;
            } else {
                System.out.println("Failed to delete patient data.");
            }
        } else {
            System.out.println("Invalid ID.");
        }
        return false;
    }

    @Override
    public boolean updatePatientContact(int id, Long contact) {
        if (id > 0 && contact != null && contact >= 1000000000L && contact <= 9999999999L) {
            boolean updated = patientRepo.updatePatientContact(id, contact);
            if (updated) {
                System.out.println("Contact updated.");
                return true;
            } else {
                System.out.println("Failed to update contact.");
            }
        } else {
            System.out.println("Invalid ID or contact number.");
        }
        return false;
    }

    @Override
    public PatientEntity findByID(int id) {
        if (id > 0) {
            return patientRepo.findByID(id);
        } else {
            System.out.println("Invalid ID.");
            return null;
        }
    }

    @Override
    public PatientEntity findByName(String name) {
        if (name != null && !name.isEmpty()) {
            return patientRepo.findByName(name);
        } else {
            System.out.println("Invalid name.");
            return null;
        }
    }

    @Override
    public PatientEntity findByWardNumber(Integer wardNo) {
        if (wardNo != null && wardNo > 0) {
            return patientRepo.findByWardNumber(wardNo);
        } else {
            System.out.println("Invalid ward number.");
            return null;
        }
    }
}
