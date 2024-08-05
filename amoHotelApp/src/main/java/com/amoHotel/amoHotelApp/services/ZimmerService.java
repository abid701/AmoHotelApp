package com.amoHotel.amoHotelApp.services;

import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import com.amoHotel.amoHotelApp.db.repositories.ZimmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZimmerService {
    private final ZimmerRepository zimmerRepository;

    @Autowired
    public ZimmerService(ZimmerRepository zimmerRepository){this.zimmerRepository = zimmerRepository;}

    public Iterable<Zimmer> getAllZimmer(){return zimmerRepository.findAll();}
}
