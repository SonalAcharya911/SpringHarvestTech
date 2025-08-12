package com.xworkz.exhibition.entity;

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
@Table(name = "artwork_details")

@NamedQuery(name="getAllArtworks",query = "select a from ArtEntity a")
public class ArtEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private Integer artID;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "artwork_title")
    private String artworkTitle;

    @Column(name = "length_in_cm")
    private Integer lengthInCm;

    @Column(name = "width_in_cm")
    private Integer widthInCm;

    @Column(name = "price")
    private Double price;

    @Column(name = "artist_email")
    private String artistEmail;

    @Column(name = "artist_contact")
    private Long artistContact;
}
