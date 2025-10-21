package com.xworkz.library.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity

@Table(name = "library_details")

@NamedQuery(name="fetchAll", query="select l from LibraryEntity l")
@NamedQuery(name="findByID", query="select l from LibraryEntity l where l.libraryID=: id")
@NamedQuery(name="deleteByID", query="delete from LibraryEntity l where l.libraryID=: id")
@NamedQuery(name="updateByID", query="update LibraryEntity l set l.libraryName=:name, l.libraryLocation=: location, l.noOfBooks=: number, l.phone=: phone, l.email=: email where l.libraryID=: id")
public class LibraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lib_id")
    private Integer libraryID;

    @Column(name = "lib_name")
    private String libraryName;

    @Column(name = "lib_location")
    private String libraryLocation;

    @Column(name = "no_of_books")
    private Integer noOfBooks;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "email")
    private String email;
}
