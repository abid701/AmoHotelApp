package com.amoHotel.amoHotelApp.db.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "buchung")
public class Buchung {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    /*@JoinColumn(name = "kunden_nr")
    private Integer kundenNr;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "zimmer_nr") */

    @ManyToOne
    @JoinColumn(name = "kunden_nr", nullable = false)
    private Kunden kunden;

    @ManyToOne
    @JoinColumn(name = "zimmer_nr", nullable = false)
    private Zimmer zimmer;

    private Date von;

    private Date bis;

    public Buchung() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKunden() {
        return kunden.getKundenNr();
    }



    public void setKunden(Kunden kunden) {
        this.kunden = kunden;
    }

    public Integer getZimmer() {
        return zimmer.getZimmerNr();
    }

    public void setZimmer(Zimmer zimmer) {
        this.zimmer = zimmer;
    }

    public Date getVon() {
        return von;
    }

    public void setVon(Date von) {
        this.von = von;
    }

    public Date getBis() {
        return bis;
    }

    public void setBis(Date bis) {
        this.bis = bis;
    }

//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Buchung{");
//        sb.append("id=").append(id);
//        sb.append(", kunden=").append(kunden);
//        sb.append(", zimmer=").append(zimmer);
//        sb.append(", von=").append(von);
//        sb.append(", bis=").append(bis);
//        sb.append('}');
//        return sb.toString();
//    }


//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Buchung{");
//        sb.append("id=").append(id);
//        sb.append(", kunden=").append(getKundenNr());
//        sb.append(", zimmer=").append(zimmer);
//        sb.append(", von=").append(von);
//        sb.append(", bis=").append(bis);
//        sb.append('}');
//        return sb.toString();
//    }
}

