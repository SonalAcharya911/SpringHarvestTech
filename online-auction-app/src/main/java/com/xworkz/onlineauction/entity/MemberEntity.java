package com.xworkz.onlineauction.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "auction_member_details")

@NamedQuery(name = "checkEmailExist",query = "select m from MemberEntity m where m.email=: email")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private Long contact;

    @Column(name = "dob")
    private String dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "state")
    private String state;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;
}
