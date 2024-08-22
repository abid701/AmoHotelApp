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

    private Integer total;

    public Buchung() {
    }

    public Buchung(Kunden kunden, Zimmer zimmer, LocalDate von, LocalDate bis) {
        this.kunden = kunden;
        this.zimmer = zimmer;
        this.von = von;
        this.bis = bis;
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

    public String getKundenVorname(){
        return kunden.getVorname();
    }

    public String getKundenNachname(){
        return kunden.getNachname();
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

    public int getTotal(){
        return total;
    }

    public void setTotal(int total){
        this.total = total;
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

