package com.example.sbjasperangular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbjasperangular.model.CityCountry;
import com.example.sbjasperangular.repository.CityCountryRepository;

import net.sf.jasperreports.engine.JRException;



@RestController
@RequestMapping("/rest/citycountry")
public class CityCountryController {
    @Autowired
    private CityCountryRepository repository;

//    @Secured({ "ROLE_demo" })
    // curl http://localhost:8080/rest/citycountry
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CityCountry> getCityCountryList() throws JRException {
    	return repository.findAll();
    }

}
