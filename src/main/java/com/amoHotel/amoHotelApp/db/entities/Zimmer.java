package com.amoHotel.amoHotelApp.db.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "zimmer")
public class Zimmer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zimmerNr;
    private String ausstattung;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buchung")
    private List<String> details;
    private String preisProNacht;
}
