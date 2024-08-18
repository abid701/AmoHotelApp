package com.amoHotel.amoHotelApp.services;

import com.amoHotel.amoHotelApp.db.entities.Kunden;
import com.amoHotel.amoHotelApp.db.repositories.KundenRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KundenService {

    private final KundenRespository kundenRespository;

    @Autowired
    public KundenService(KundenRespository kundenRespository) {
        this.kundenRespository = kundenRespository;
    }

    public Iterable<Kunden> getAllKunden(){
        return kundenRespository.findAll();
    }
}

