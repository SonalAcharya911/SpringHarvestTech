package com.xworkz.patient.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "patient_info")

@NamedQuery(name="findByName",query = "select p from PatientEntity p where p.name=: name")
@NamedQuery(name="findByWardNumber",query = "select p from PatientEntity p where p.wardNumber=: wardNumber")

@NamedQuery(name = "updateDoctorByBloodGroupAndSickness",query = "update PatientEntity p set p.preferredDoctor=: doctor where p.bloodGroup=: bloodGroup and p.sickness=: sickness")
@NamedQuery(name = "updateAgeByID", query = "update PatientEntity p set p.age=: age where p.patientID=: id")
@NamedQuery(name = "updateContactByNameAndID",query = "update PatientEntity p set p.contact=: contact where p.name=:name and p.patientID=: id")

@NamedQuery(name = "getAllPatientNames",query = "select p.name from PatientEntity p")
@NamedQuery(name = "getAllPatientsDoctorSickness",query = "select p.name,p.sickness,p.preferredDoctor from PatientEntity p")
@NamedQuery(name = "getAllWardNos",query = "select p.wardNumber from PatientEntity p")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer patientID;

    @Column(name = "patient_name")
    private String name;

    @Column(name = "patient_age")
    private Integer age;

    @Column(name = "patient_gender")
    private String gender;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "patient_contact")
    private Long contact;

    @Column(name = "sickness_description")
    private String sickness;

    @Column(name = "preferred_doctor")
    private String preferredDoctor;

    @Column(name = "ward_number")
    private Integer wardNumber;
}

