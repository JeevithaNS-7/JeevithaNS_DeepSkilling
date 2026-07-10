package com.cognizant.spring_country_api.controller;
import com.cognizant.spring_country_api.model.Country;
import com.cognizant.spring_country_api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        return countryService.getCountry(code);

    }

}