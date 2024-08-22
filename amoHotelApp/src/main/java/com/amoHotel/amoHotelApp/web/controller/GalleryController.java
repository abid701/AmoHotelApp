package com.amoHotel.amoHotelApp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GalleryController {
    @GetMapping("/gallery")
    public String showGallery(){
        return "view/gallery";
    }
}
