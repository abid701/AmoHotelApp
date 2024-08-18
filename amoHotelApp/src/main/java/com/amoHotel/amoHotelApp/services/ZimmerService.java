package com.amoHotel.amoHotelApp.services;

import com.amoHotel.amoHotelApp.db.entities.Buchung;
import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import com.amoHotel.amoHotelApp.db.repositories.ZimmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ZimmerService {
    @Autowired
    private final ZimmerRepository zimmerRepository;
    @Autowired
    private final BuchungService buchungService;


    public ZimmerService(ZimmerRepository zimmerRepository, BuchungService buchungService){
        this.zimmerRepository = zimmerRepository;
        this.buchungService = buchungService;
    }

    public Iterable<Zimmer> getAllZimmer(){
        return zimmerRepository.findAll();
    }

    public Zimmer getZimmerByNumber(int id){
        return zimmerRepository.findById(id).orElse(null);
    }

    public List<Zimmer> getAllZimmerByType(String type){
        return zimmerRepository.findAllZimmerByAusstattung(type);
    }

    public List<Buchung> getBuchungListByZimmer(Zimmer zimmer){
        return buchungService.getBuchungByZimmer(zimmer);
    }

}
