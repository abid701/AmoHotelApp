package com.amoHotel.amoHotelApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//		registry.addViewController("/home").setViewName("view/home");
//		registry.addViewController("/").setViewName("view/home");
		registry.addViewController("/homePage").setViewName("view/homePage");
		registry.addViewController("/login").setViewName("view/login");
	}

}
