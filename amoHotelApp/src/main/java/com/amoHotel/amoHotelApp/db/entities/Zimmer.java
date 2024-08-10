package com.amoHotel.amoHotelApp.db.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "zimmer")
public class Zimmer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zimmer_nr")

    private int zimmerNr;

    private String ausstattung;

    @Column(name = "details")
    private String details;

    private String preisProNacht;


    @OneToMany(mappedBy = "zimmer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Buchung> buchungen = new HashSet<>();

    public Zimmer() {
    }

    public Set<Buchung> getBuchungen() {
        return buchungen;
    }

    public void setBuchungen(Set<Buchung> buchungen) {
        this.buchungen = buchungen;
    }

    public int getZimmerNr() {
        return zimmerNr;
    }

    public void setZimmerNr(int zimmerNr) {
        this.zimmerNr = zimmerNr;
    }

    // Fragen, ob es erklären braucht.
    public String getAusstattung() {
        if (ausstattung.length() > 5){
            return ausstattung.substring(0,1).toUpperCase() + ausstattung.substring(1, 7).toLowerCase()
                    + ausstattung.substring(7, 8).toUpperCase() + ausstattung.substring(8).toLowerCase();
        }
        return ausstattung.substring(0,1).toUpperCase() + ausstattung.substring(1).toLowerCase();
    }

    public void setAusstattung(String ausstattung) {
        this.ausstattung = ausstattung;
    }
    // Braucht es erklären?
    public String getDetails() {
        details = details.replace("[", "");
        details = details.replace("]", "");
        details = details.replace("\"", " ");
        details = details.replace(" , ", ", ").strip();
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



//    public Zimmer(int zimmerNr, String ausstattung, String details, String preisProNacht) {
//        this.zimmerNr = zimmerNr;
//        this.ausstattung = ausstattung;
//        this.details = details;
//        this.preisProNacht = preisProNacht;
//    }
//
//
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("Zimmer{");
//        sb.append("zimmerNr=").append(zimmerNr);
//        sb.append(", ausstattung='").append(ausstattung).append('\'');
//        sb.append(", details='").append(details).append('\'');
//        sb.append(", preisProNacht='").append(preisProNacht).append('\'');
//        sb.append('}');
//        return sb.toString();
//    }



}
