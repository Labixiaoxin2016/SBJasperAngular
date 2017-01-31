package com.example.sbjasperangular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbjasperangular.model.City;
import com.example.sbjasperangular.model.MLabel;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/ajax/report")
public class AjaxController {
	@Autowired
	private ApiService apiService;

	@Secured({ "ROLE_demo" })
	@RequestMapping(method = RequestMethod.POST)
	public List<City> generateReport(@RequestBody List<City> cities) throws JRException {
		apiService.generateReport(cities);
		return cities;
	}

	@Secured({ "ROLE_demo" })
	@RequestMapping(value="/label",method = RequestMethod.POST)
	public void addLabelMono(@RequestBody MLabel obj) throws JRException {
		apiService.addMLabelMono(obj.getLabelId(), obj.getLabelName());

	}

}
