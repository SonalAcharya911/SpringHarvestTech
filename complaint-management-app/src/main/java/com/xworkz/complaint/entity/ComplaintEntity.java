package com.xworkz.complaint.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@RequiredArgsConstructor
@Table(name = "complaint_details")

@NamedQuery(name="getAllComplaints",query="select c from ComplaintEntity c")

@NamedQuery(name = "updateComplaint",query = "update ComplaintEntity c set c.complainantName=: complainantName, " +
        "c.email=: email, " +
        "c.contact=: contact, " +
        "c.category=: category, " +
        "c.description=: description, " +
        "c.location=: location " +
        "where c.complaintID=: complaintID")

@NamedQuery(name = "deleteComplaint",query = "delete from ComplaintEntity c where c.complaintID=: complaintID")
public class ComplaintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private Integer complaintID;

    @Column(name = "complainant_name")
    private String complainantName;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private Long contact;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;
}
