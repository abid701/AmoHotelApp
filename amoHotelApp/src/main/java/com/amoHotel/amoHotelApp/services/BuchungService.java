package com.amoHotel.amoHotelApp.services;


import com.amoHotel.amoHotelApp.db.entities.Buchung;
import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import com.amoHotel.amoHotelApp.db.repositories.BuchungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuchungService {

    private final BuchungRepository buchungRepository;

    @Autowired
    public BuchungService(BuchungRepository buchungRepository) {
        this.buchungRepository = buchungRepository;
    }

    public Iterable<Buchung> getAllBuchungen(){return buchungRepository.findAll();}

    public Buchung getBuchungById(int id){return buchungRepository.findById(id).orElse(null);}

    public List<Buchung> getBuchungByZimmer(Zimmer zimmer){
        return buchungRepository.findAllByZimmer(zimmer);
    }

}
