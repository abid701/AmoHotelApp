package com.amoHotel.amoHotelApp.web.controller;

import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import com.amoHotel.amoHotelApp.services.ZimmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ZimmerController {
    private final ZimmerService zimmerService;

    @Autowired
    public ZimmerController(ZimmerService zimmerService){this.zimmerService = zimmerService;}

    @GetMapping("/homePage") // localhost:8081/homePage
    public String  showZimmerList (Model model){
        Iterable<Zimmer> ZimmerList = zimmerService.getAllZimmer();
        model.addAttribute("zimmerList", ZimmerList);
        return "view/homePage";
    }

}
