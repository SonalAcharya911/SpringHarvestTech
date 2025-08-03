package com.xworkz.diary.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "application_info")

@NamedQuery(name="findByApplicationName",query="select a from ApplicationEntity a where a.applicationName=:appName")
@NamedQuery(name="findByAppSize", query="select a from ApplicationEntity a where a.applicationSize =: appSize")
@NamedQuery(name="findByCompany", query="select a from ApplicationEntity a where a.company =: company")
@NamedQuery(name="findByNoOfUsers",query="select a from ApplicationEntity a where a.noOfUsers=: noOfUsers")
@NamedQuery(name="findByRating",query="select a from ApplicationEntity a where a.rating=:rating")
@NamedQuery(name="findByLaunchDate",query="select a from ApplicationEntity a where a..launchDate=: launchDate")
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Integer applicationID;

    @Column(name = "application_name")
    private String applicationName;

    @Column(name = "application_size")
    private String applicationSize;

    @Column(name = "company")
    private String company;

    @Column(name = "no_of_users")
    private Integer noOfUsers;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "launch_date")
    private LocalDate launchDate;
}
