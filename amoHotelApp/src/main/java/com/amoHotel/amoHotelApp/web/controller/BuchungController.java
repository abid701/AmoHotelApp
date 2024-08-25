package com.amoHotel.amoHotelApp.web.controller;

import org.springframework.ui.Model;
import com.amoHotel.amoHotelApp.db.entities.Buchung;
import com.amoHotel.amoHotelApp.services.BuchungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("buchungen/delete/{id}")
    public String deleteBuchung(@PathVariable int id, Model model) {
        Buchung buchung = buchungService.getBuchungById(id);
        System.out.println(buchung);
        if (buchung != null) {
            buchungService.deleteBuchung(buchung);
        }
        Iterable<Buchung>buchungen = buchungService.getAllBuchungen();
        model.addAttribute("buchungen", buchungen);
        return "view/buchungen";
    }
}
