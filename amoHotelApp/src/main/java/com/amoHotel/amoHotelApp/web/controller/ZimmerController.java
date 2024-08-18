package com.amoHotel.amoHotelApp.web.controller;

import com.amoHotel.amoHotelApp.db.entities.Buchung;
import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import com.amoHotel.amoHotelApp.services.ZimmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ZimmerController {
    private final ZimmerService zimmerService;


    @Autowired
    public ZimmerController(ZimmerService zimmerService){
        this.zimmerService = zimmerService;}


    @GetMapping("/homePage")
    public String showZimmerList(@RequestParam(value = "zimmerNr", required = false) Integer zimmerNr,
                                 @RequestParam(value = "zimmerType", required = false) String zimmerType,
                                 Model model) {

        Iterable<Zimmer> zimmerList;

        if (zimmerNr != null) {
            Zimmer zimmer = zimmerService.getZimmerByNumber(zimmerNr);
            if (zimmer != null) {
                zimmerList = List.of(zimmer);
                System.out.println("zimmer number is: " + zimmer.getZimmerNr());
            } else {
                zimmerList = List.of();
                System.out.println("zimmer was not found");
            }
        } else {
            zimmerList = zimmerService.getAllZimmer();
            System.out.println("show all zimmer");
        }

        if (zimmerType != null)  {
            System.out.println("its working");
            System.out.println(zimmerType);
            Iterable<Zimmer> alleZimmerByType = zimmerService.getAllZimmerByType(zimmerType);
            System.out.println(zimmerService.getAllZimmerByType(zimmerType));
            zimmerList = alleZimmerByType;
            if(zimmerType.equals("Alle Zimmer")){
                zimmerList = zimmerService.getAllZimmer();
                System.out.println("show all zimmer");
            }
        }
        model.addAttribute("zimmerList", zimmerList);
        return "view/homePage";
    }

    @GetMapping("/zimmerDetails")
    public String getZimmerDetail(@RequestParam("zimmer") Zimmer zimmer, Model model) {

        List<Buchung> buchungList = zimmerService.getBuchungListByZimmer(zimmer);

        model.addAttribute("zimmer", zimmer);
        model.addAttribute("buchungList", buchungList);

        return "view/zimmerDetails";
    }

}
