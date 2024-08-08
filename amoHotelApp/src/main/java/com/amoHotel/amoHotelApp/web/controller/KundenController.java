package com.amoHotel.amoHotelApp.web.controller;

import com.amoHotel.amoHotelApp.db.entities.Kunden;
import com.amoHotel.amoHotelApp.services.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class KundenController {

    private final KundenService kundenService;

    @Autowired
    public KundenController(KundenService kundenService) {
        this.kundenService = kundenService;
    }
    @GetMapping("/kunden") // localhost:8081/kunden
    public String  showKundenList (Model model){
        Iterable<Kunden> kundenList = kundenService.getAllKunden();
        model.addAttribute("kundenList", kundenList);
        return "view/kunden";
    }


}
