package com.amoHotel.amoHotelApp.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KundenController {

    @GetMapping("/homePage") // localhost:8081/showViewPage
    public String passParametersWithModel(Model model) {
        model.addAttribute("message", "Hallo mit Model");
        model.addAttribute("welcomeMessage", "welcome2");
        // View aufrufen
        return "view/homePage";
    }
}
