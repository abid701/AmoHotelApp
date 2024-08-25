package com.amoHotel.amoHotelApp.services;

import com.amoHotel.amoHotelApp.db.entities.Buchung;
import com.amoHotel.amoHotelApp.db.entities.Kunden;
import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import com.amoHotel.amoHotelApp.db.repositories.BuchungRepository;
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
    @Autowired
    private final KundenService kundenService;


    public ZimmerService(ZimmerRepository zimmerRepository, BuchungService buchungService, KundenService kundenService){
        this.zimmerRepository = zimmerRepository;
        this.buchungService = buchungService;
        this.kundenService = kundenService;
    }

    public Iterable<Zimmer> getAllZimmer(){
        return zimmerRepository.findAll();
    }

    public Zimmer getZimmerByNumber(int zimmerNr){
        return zimmerRepository.findById(zimmerNr).orElse(null);
    }

    public List<Zimmer> getAllZimmerByType(String type){
        return zimmerRepository.findAllZimmerByAusstattung(type);
    }

    public List<Buchung> getBuchungListByZimmer(Zimmer zimmer){
        return buchungService.getBuchungByZimmer(zimmer);
    }

    public Kunden getKundenById(Integer kundenNr) {
        return kundenService.getKundenById(kundenNr);
    }

    public Buchung saveBuchungFromZimmer(Buchung buchung) {
        return buchungService.saveBuchung(buchung);
    }

    public Kunden saveKundenFromZimmer(Kunden kunden){
        return kundenService.saveKunden(kunden);
    }

}
