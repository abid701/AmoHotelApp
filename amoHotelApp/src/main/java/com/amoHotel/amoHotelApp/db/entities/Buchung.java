package com.amoHotel.amoHotelApp.db.entities;

import jakarta.persistence.*;

import java.util.Date;

/*
@Entity
@Table(name = "buchung")
public class Buchung {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "kundenNr")
    private Integer kundenNr;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "zimmerNr")
    private Date von;
    private Date bis;
}
*/