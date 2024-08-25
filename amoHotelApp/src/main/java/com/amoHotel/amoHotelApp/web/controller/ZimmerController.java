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
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class ZimmerController {
    private final ZimmerService zimmerService;


    @Autowired
    public ZimmerController(ZimmerService zimmerService){
        this.zimmerService = zimmerService;}

    /**
     * Diese Methode zeigt die Liste der Zimmer auf der Startseite an.
     *
     * @param zimmerNr   Die Nummer eines bestimmten Zimmers (optional). Wenn angegeben, wird nur dieses Zimmer angezeigt.
     * @param zimmerType Der Typ der Zimmer (optional). Wenn angegeben, werden nur Zimmer dieses Typs angezeigt.
     * @param model      Das Modell, um die Daten an die View weiterzugeben.
     * @return           Gibt die View-Seite "homePage" zurück.
     *
     * Diese Methode filtert Zimmer basierend auf der Zimmernummer oder dem Zimmertyp und berechnet die Verfügbarkeit jedes Zimmers.
     */
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

        // die Namen jedes Monats im Kalender auf der Seite.
        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();
        Month nextMonthDate = today.plusMonths(1).getMonth();
        Month thirdMonthDate = today.plusMonths(2).getMonth();
        Month fourthMonthDate = today.plusMonths(3).getMonth();


        model.addAttribute("currentMonth", currentMonth);
        model.addAttribute("nextMonth", nextMonthDate);
        model.addAttribute("thirdMonth", thirdMonthDate);
        model.addAttribute("fourthMonth", fourthMonthDate);
        model.addAttribute("zimmer", zimmer);
        model.addAttribute("buchungList", buchungList);

        return "view/zimmerDetails";
    }



    @GetMapping("/zimmerBuchen")
    public String showZimmerBuchen(@RequestParam(value = "zimmer", required = false) Zimmer zimmer, Model model) {
        List<Buchung> buchungList = zimmerService.getBuchungListByZimmer(zimmer);

        // die Namen jedes Monats im Kalender auf der Seite.
        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();
        Month nextMonthDate = today.plusMonths(1).getMonth();
        Month thirdMonthDate = today.plusMonths(2).getMonth();
        Month fourthMonthDate = today.plusMonths(3).getMonth();

        model.addAttribute("currentMonth", currentMonth);
        model.addAttribute("nextMonth", nextMonthDate);
        model.addAttribute("thirdMonth", thirdMonthDate);
        model.addAttribute("fourthMonth", fourthMonthDate);
        model.addAttribute("zimmer", zimmer);
        model.addAttribute("buchungList", buchungList);

        return "view/zimmerBuchen";
    }

    /**
     * Diese Methode verarbeitet die Buchung eines Zimmers und erstellt oder verknüpft einen Kunden.
     *
     * @param kundenNr      Die Nummer des Kunden, falls vorhanden. Wird verwendet, um einen bestehenden Kunden zu finden.
     * @param vorname       Der Vorname des Kunden, falls ein neuer Kunde erstellt wird.
     * @param nachname      Der Nachname des Kunden, falls ein neuer Kunde erstellt wird.
     * @param email         Die E-Mail-Adresse des Kunden, falls ein neuer Kunde erstellt wird.
     * @param adresse       Die Adresse des Kunden, falls ein neuer Kunde erstellt wird.
     * @param zimmerNr      Die Nummer des Zimmers, das gebucht werden soll.
     * @param von           Das Startdatum der Buchung.
     * @param bis           Das Enddatum der Buchung.
     * @param numberOfPeople Die Anzahl der Personen, die im Zimmer übernachten werden.
     * @param breakFast     Gibt an, ob Frühstück gewünscht ist ("Ja" oder "Nein").
     * @param total         Der Gesamtpreis der Buchung. Wird basierend auf Zimmerpreis, Anzahl der Tage, Personen und Frühstück berechnet.
     * @param model         Das Modell, das verwendet wird, um Daten an die View weiterzugeben.
     * @return              Gibt die View-Seite zurück, entweder "zimmerBuchen" bei einem Fehler oder leitet zu "zimmerDetails" weiter.
     *
     * Diese Methode überprüft, ob das Zimmer für die angegebenen Daten bereits gebucht ist und berechnet den Gesamtpreis.
     * Wenn die Kundenummer nicht vorhanden ist, wird ein neuer Kunde mit den übergebenen Daten erstellt.
     * Bei erfolgreichen Buchungen wird die Buchung gespeichert und der Nutzer zur Zimmer-Detailseite weitergeleitet.
     */
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
        List<Buchung> buchungList = zimmerService.getBuchungListByZimmer(zimmer);
        System.out.println(total);

        // Berechnung der Gesamtkosten der Buchungen.
        Long diffInDays = ChronoUnit.DAYS.between(von, bis);
        if(diffInDays > 0){
            total += zimmer.getPreisProNacht() * Math.toIntExact(diffInDays);
            System.out.println(total);
        }

        if (numberOfPeople > 0){
            total *= numberOfPeople;
        }

        if(breakFast.equals("Ja")){
            // Jedes Frühstück kostet 10 Euro
            int breakFastPrice = 10 * Math.toIntExact(diffInDays) * numberOfPeople;
            total += breakFastPrice;
            System.out.println(total);
        } else if (breakFast.equals("Nein")) {
            System.out.println(total);
        }

        model.addAttribute("zimmer", zimmer);
        model.addAttribute("total", total);

        // Überprüft, ob das Zimmer zum angegebenen Datum bereits gebucht ist.
        for (Buchung buchung : buchungList){
            if (von.isBefore(buchung.getBis()) && bis.isAfter(buchung.getVon())){
                model.addAttribute("error", "Das Zimmer ist in dem angegebenen Zeitraum" +
                        " bereits gebucht.");
                return "view/zimmerBuchen";
            } else if (von.isEqual(buchung.getBis()) || bis.isEqual(buchung.getVon())) {
                model.addAttribute("error", "Das Zimmer ist in dem angegebenen Zeitraum" +
                        " bereits gebucht.");
                return "view/zimmerBuchen";
            }
        }
        // Überprüft, ob die Daten korrekt sind.
        if (zimmer == null || von.isBefore(LocalDate.now()) || bis.isBefore(von)) {
            model.addAttribute("error", "Zu diesem Zeitpunkt ist keine Buchung möglich.");
            return "view/zimmerBuchen";
        }

        // Überprüft, ob der angegebene Kunde unter Kundennummer verfügbar ist, wenn nicht, einen neuen Kunden erstellt wird.
        Kunden kunden;
        if (kundenNr != null) {
            kunden = zimmerService.getKundenById(kundenNr);
            if (kunden == null) {
                model.addAttribute("error", "Kunden Nummer ist nicht verfügbar.");
                return "view/zimmerBuchen";
            }
        } else {
            kunden = new Kunden();
            kunden.setVorname(vorname);
            kunden.setNachname(nachname);
            kunden.setEmail(email);
            kunden.setAdresse(adresse);
            kunden = zimmerService.saveKundenFromZimmer(kunden);
        }

        Buchung buchung = new Buchung(kunden, zimmer, von, bis);
        buchung.setTotal(total);
        zimmerService.saveBuchungFromZimmer(buchung);
        return "redirect:/zimmerDetails?zimmer=" + zimmer.getZimmerNr();
    }
}
