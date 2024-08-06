package com.amoHotel.amoHotelApp.db.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "zimmer")
public class Zimmer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int", name = "zimmer_nr")

    private Long zimmerNr;

    private String ausstattung;
   //TODO: diese annotaion ist nur für testen, muss entfernen werden
    //@ElementCollection
    @Column(name = "details")
    private String details;

    private String preisProNacht;

    public Zimmer() {
    }

    public Long getZimmerNr() {
        return zimmerNr;
    }

    public void setZimmerNr(Long zimmerNr) {
        this.zimmerNr = zimmerNr;
    }

    public String getAusstattung() {
        return ausstattung;
    }

    public void setAusstattung(String ausstattung) {
        this.ausstattung = ausstattung;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPreisProNacht() {
        return preisProNacht;
    }

    public void setPreisProNacht(String preisProNacht) {
        this.preisProNacht = preisProNacht;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Zimmer{");
        sb.append("zimmerNr=").append(zimmerNr);
        sb.append(", ausstattung='").append(ausstattung).append('\'');
        sb.append(", details='").append(details).append('\'');
        sb.append(", preisProNacht='").append(preisProNacht).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
