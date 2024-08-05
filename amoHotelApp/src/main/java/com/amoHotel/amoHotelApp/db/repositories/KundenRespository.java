package com.amoHotel.amoHotelApp.db.repositories;

import com.amoHotel.amoHotelApp.db.entities.Kunden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KundenRespository extends CrudRepository<Kunden, Long> {
}
