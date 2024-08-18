package com.amoHotel.amoHotelApp.db.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "buchung")
public class Buchung implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "kunden_nr", nullable = false)
    private Kunden kunden;

    @ManyToOne
    @JoinColumn(name = "zimmer_nr", nullable = false)
    private Zimmer zimmer;

    private LocalDate von;

    private LocalDate bis;

    public Buchung() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKundenNr() {
        return kunden.getKundenNr();
    }

    public Kunden getKunden() {
        return kunden;
    }

    public void setKunden(Kunden kunden) {
        this.kunden = kunden;
    }

    public Integer getZimmerNr() {
        return zimmer.getZimmerNr();
    }

    public Zimmer getZimmer() {
        return zimmer;
    }

    public void setZimmer(Zimmer zimmer) {
        this.zimmer = zimmer;
    }

    public LocalDate getVon() {
        return von;
    }

    public void setVon(LocalDate von) {
        this.von = von;
    }

    public LocalDate getBis() {
        return bis;
    }

    public void setBis(LocalDate bis) {
        this.bis = bis;
    }

}

