package com.amoHotel.amoHotelApp.web.controller;

import com.amoHotel.amoHotelApp.db.entities.Buchung;
import com.amoHotel.amoHotelApp.db.entities.Kunden;
import com.amoHotel.amoHotelApp.db.entities.Zimmer;
import com.amoHotel.amoHotelApp.services.ZimmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


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
        Map<Integer, String> availabilityMap = new HashMap<>();

        if (zimmerNr != null) {
            Zimmer zimmer = zimmerService.getZimmerByNumber(zimmerNr);
            if (zimmer != null) {
                zimmerList = List.of(zimmer);
            } else {
                zimmerList = List.of();
            }
        } else {
            zimmerList = zimmerService.getAllZimmer();
        }

        if (zimmerType != null) {
            if (zimmerType.equals("Alle Zimmer")) {
                zimmerList = zimmerService.getAllZimmer();
            } else {
                zimmerList = zimmerService.getAllZimmerByType(zimmerType);
            }
        }
        

        for (Zimmer zimmer : zimmerList) {
            List<Buchung> buchungen = zimmerService.getBuchungListByZimmer(zimmer);

            LocalDate today = LocalDate.now();

            Buchung nextBuchung = null;

            for (Buchung buchung : buchungen) {

                if (buchung.getBis().isAfter(today)) {
                    if (nextBuchung == null || buchung.getVon().isBefore(nextBuchung.getVon())) {
                        nextBuchung = buchung;
                    }
                }
            }

            String availabilityStatus;
            if (nextBuchung != null) {
                if (nextBuchung.getVon().isAfter(today)) {
                    availabilityStatus = "Verfügbar bis " + nextBuchung.getVon().minusDays(1);
                } else {
                    availabilityStatus = "Gebucht bis " + nextBuchung.getBis();
                }
            } else {
                availabilityStatus = "Verfügbar";
            }

            availabilityMap.put(zimmer.getZimmerNr(), availabilityStatus);
        }

        model.addAttribute("zimmerList", zimmerList);
        model.addAttribute("availabilityMap", availabilityMap);
        return "view/homePage";
    }


    @GetMapping("/zimmerDetails")
    public String showZimmerDetail(@RequestParam("zimmer") Zimmer zimmer, Model model) {

        List<Buchung> buchungList = zimmerService.getBuchungListByZimmer(zimmer);

        model.addAttribute("zimmer", zimmer);
        model.addAttribute("buchungList", buchungList);

        return "view/zimmerDetails";
    }



    @GetMapping("/zimmerBuchen")
    public String showZimmerBuchen(@RequestParam(value = "zimmer", required = false) Zimmer zimmer, Model model) {
        List<Buchung> buchungList = zimmerService.getBuchungListByZimmer(zimmer);

        model.addAttribute("zimmer", zimmer);
        model.addAttribute("buchungList", buchungList);

        return "view/zimmerBuchen";
    }


    @PostMapping("/zimmerBuchenUndKunden")
    public String zimmerBuchenUndKunden(@RequestParam(required = false) Integer kundenNr,
                                        @RequestParam(required = false) String vorname,
                                        @RequestParam(required = false) String nachname,
                                        @RequestParam(required = false) String email,
                                        @RequestParam(required = false) String adresse,
                                        @RequestParam int zimmerNr,
                                        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate von,
                                        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate bis,
                                        @RequestParam int numberOfPeople,
                                        @RequestParam(required = false) String breakFast,
                                        @RequestParam(required = false) Integer total,
                                        Model model) {

        Zimmer zimmer = zimmerService.getZimmerByNumber(zimmerNr);
        total = zimmer.getPreisProNacht();
        int breakFastPrice = 10;
        System.out.println(total);

        Long diffInDays = ChronoUnit.DAYS.between(von, bis);
        System.out.println(diffInDays);
        if(diffInDays > 0){
            total += zimmer.getPreisProNacht() * Math.toIntExact(diffInDays);
            System.out.println(total);
        }
        if(breakFast.equals("Ja")){
            breakFastPrice *= Math.toIntExact(diffInDays);
            total += breakFastPrice;
        }
        if (numberOfPeople > 1){
            System.out.println("there are more than one person");
        }
        model.addAttribute("zimmer", zimmer);
        model.addAttribute("total", total);
        if (zimmer == null || von.isBefore(LocalDate.now()) || bis.isBefore(von)) {
            model.addAttribute("error", "Zu diesem Zeitpunkt ist keine Buchung möglich.");
            return "view/zimmerBuchen";
        }

        Kunden kunde;
        if (kundenNr != null) {
            kunde = zimmerService.getKundenById(kundenNr);
            if (kunde == null) {
                model.addAttribute("error", "Kunden Nummer ist nicht verfügbar.");
                return "view/zimmerBuchen";
            }
        } else {
            kunde = new Kunden();
            kunde.setVorname(vorname);
            kunde.setNachname(nachname);
            kunde.setEmail(email);
            kunde.setAdresse(adresse);
            kunde = zimmerService.saveKundenFromZimmer(kunde);
        }

        Buchung buchung = new Buchung(kunde, zimmer, von, bis);
        buchung.setTotal(total);
        zimmerService.saveBuchungFromZimmer(buchung);
        //  "view/zimmerDetails";
        return "redirect:/zimmerDetails?zimmer=" + zimmer.getZimmerNr();
    }
}
