package com.amoHotel.amoHotelApp.db.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zimmer")
public class Zimmer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int", name = "zimmer_nr")

    private Long zimmerNr;

    private String ausstattung;
    // diese annotaion ist nur für testen, muss entfernen werden
    @ElementCollection
    @Column(name = "details")
    private List<String> details;

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

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
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
    //    sb.append(", details=").append(details);
        sb.append(", details=");

        for(String detail : details) {
            sb.append(detail);
            sb.append(", ");
        }
        sb.append("\b\b");
        sb.append(", preisProNacht='").append(preisProNacht).append('\'');
        sb.append('}');
        return sb.toString();
    }


//        public List<String> getDetailsAsList() {
//            List<String> detailsList = new ArrayList<>();
//            if (details!= null) {
//                try {
//                    JSONArray jsonArray = new JSONArray(details);
//                    for (int i = 0; i < jsonArray.length(); i++) {
//                        detailsList.add(jsonArray.getString(i));
//                    }
//                } catch (JSONException e) {
//                    System.out.println("Json not working!");
//                }
//            }
//            return detailsList;
//        }


}
