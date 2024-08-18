package com.amoHotel.amoHotelApp.db.repositories;

import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZimmerRepository extends CrudRepository<Zimmer, Integer> {
    List<Zimmer> findAllZimmerByAusstattung(String type);
}
