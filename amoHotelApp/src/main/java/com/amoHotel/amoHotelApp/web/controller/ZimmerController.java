package com.amoHotel.amoHotelApp.web.controller;

import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import com.amoHotel.amoHotelApp.services.ZimmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ZimmerController {
    private final ZimmerService zimmerService;

    @Autowired
    public ZimmerController(ZimmerService zimmerService){this.zimmerService = zimmerService;}

    @GetMapping("/homePage") // localhost:8081/homePage
    public String  showZimmerList (Model model){
        Iterable<Zimmer> zimmerList = zimmerService.getAllZimmer();
        model.addAttribute("zimmerList", zimmerList);
        return "view/homePage";
    }

    @GetMapping("/zimmerDetails")
    public String getZimmerDetail(@RequestParam("zimmerNr") int zimmerNr, Model model) {
        Zimmer zimmer = zimmerService.findZimmerByNumber(zimmerNr);
        
        model.addAttribute("zimmer", zimmer);
        
        return "view/zimmerDetails";
    }

}
