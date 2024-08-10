package com.amoHotel.amoHotelApp.db.repositories;

import com.amoHotel.amoHotelApp.db.entities.Buchung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuchungRepository extends CrudRepository<Buchung, Integer> {
}

