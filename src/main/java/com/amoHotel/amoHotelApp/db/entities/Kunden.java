package com.amoHotel.amoHotelApp.db.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "kunden")
public class Kunden implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kundenNr;
    private String vorname;
    private String nachname;
    private String email;
    private String adresse;

}
