package de.inge.amoHotel.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/showHomePage") // localhost:8081/showHomePage
    public String passParametersWithModel(Model model) {
        model.addAttribute("message", "Die erste Seite´funktioniert");
        return "view/homePage";
    }
}
