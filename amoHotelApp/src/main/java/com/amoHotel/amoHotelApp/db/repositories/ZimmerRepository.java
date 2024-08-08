package com.amoHotel.amoHotelApp.db.repositories;

import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZimmerRepository extends CrudRepository<Zimmer, Integer> {
   // Zimmer findByZimmerNr(int zimmerNr);
}
