package com.amoHotel.amoHotelApp.web.controller;

import org.springframework.ui.Model;
import com.amoHotel.amoHotelApp.db.entities.Buchung;
import com.amoHotel.amoHotelApp.services.BuchungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuchungController {
    private final BuchungService buchungService;

    @Autowired
    public BuchungController(BuchungService buchungService) {
        this.buchungService = buchungService;
    }

    @GetMapping("/buchungen")
    public String showBuchungen(Model model){
        Iterable<Buchung>buchungen = buchungService.getAllBuchungen();
        model.addAttribute("buchungen", buchungen);
        return "view/buchungen";
    }
}
