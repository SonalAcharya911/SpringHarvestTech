package com.xworkz.passport.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "user_details")

@NamedQuery(name = "checkEmailExist",query = "select u from UserEntity u where u.email=: email")
@NamedQuery(name = "checkLoginIdExist",query = "select u from UserEntity u where u.loginID=: loginID")
@NamedQuery(name = "checkContactExist",query = "select u from UserEntity u where u.contact=: contact")

@NamedQuery(name = "getAll",query = "select u from UserEntity u")

@NamedQuery(name = "updatePassport", query = "update UserEntity u set u.passportOffice=: passportOffice," +
        "u.givenName=: givenName," +
        "u.surname=: surname," +
        "u.dob=: dob," +
        "u.email=: email," +
        "u.contact=: contact," +
        "u.loginID=: loginID," +
        "u.password=: password," +
        "u.confirmPassword=: confirmPassword," +
        "u.hintQuestion=: hintQuestion," +
        "u.hintAnswer=: hintAnswer" +
        " where u.userID=: id")

@NamedQuery(name = "deletePassport",query = "delete from UserEntity u where u.userID=: userID")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userID;

    @Column(name = "passport_office")
    private String passportOffice;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "surname")
    private String surname;

    @Column(name = "dob")
    private String dob;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private Long contact;

    @Column(name = "login_id")
    private String loginID;

    @Column(name = "password")
    private String password;

    @Column(name = "confirm_password")
    private String confirmPassword;

    @Column(name = "hint_question")
    private String hintQuestion;

    @Column(name = "hint_answer")
    private String hintAnswer;
}
