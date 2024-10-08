package com.amoHotel.amoHotelApp.db.repositories;

import com.amoHotel.amoHotelApp.db.entities.Buchung;
import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuchungRepository extends CrudRepository<Buchung, Integer> {
    List<Buchung> findAllByZimmer(Zimmer zimmer);
}

