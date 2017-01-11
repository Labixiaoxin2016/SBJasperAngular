package com.example.sbjasperangular.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sbjasperangular.model.City;
import com.example.sbjasperangular.model.CityCountry;
import com.example.sbjasperangular.model.Country;
import com.example.sbjasperangular.report.CustomJRDataSource;
import com.example.sbjasperangular.repository.CityCountryRepository;
import com.example.sbjasperangular.repository.CityRepository;
import com.example.sbjasperangular.repository.CountryRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;



@Component
public class ApiService {
	final static Logger logger = Logger.getLogger(ApiService.class);

	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private CityCountryRepository cityCountryRepository;

	/**
	 * あらかじめ結合済みのEntity Modelを用意し、そこに格納する。画面と１：１の関係にしやすい。
	 * @param cityName
	 * @param countryName
	 * @param population
	 */
	public void addCityCountry(String cityName, String countryName, Long population) {
		CityCountry city = new CityCountry();
		city.setName(cityName);
		city.setPopulation(population);
		city.setCountryName(countryName);
		cityCountryRepository.save(city);
	}

	public void addCity(String cityName, String countryName, Long population) {
		// setXXXの戻り値を自身の型にするやりかた→メソッドチェーンができる。
//		City city = new City().setName(cityName).setPopulation(population);
		City city = new City();
		city.setName(cityName);
		city.setPopulation(population);

		Country country = countryRepository.findOne(countryName);
		city.setCountry(country);
		country.addCity(city);
		cityRepository.save(city);

	}

	public void addCountry(String countryName) {
		// setXXXの戻り値を自身の型にするやりかた→メソッドチェーンができる。
//		Country country = new Country().setName(countryName);
		Country country = new Country();
		country.setName(countryName);
		country = countryRepository.save(country);
	}

	public void generateReport(List<City> cities) throws JRException {
		JasperReport jasperReport;
		JasperPrint jasperPrint;
		jasperReport = JasperCompileManager
				.compileReport("src/main/resources/static/jasper/report.jrxml");
		CustomJRDataSource<City> dataSource = new CustomJRDataSource<City>()
				.initBy(cities);
		jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(),
				dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint,
				"src/main/resources/static/jasper/report.pdf");
	}

	@PostConstruct
	public void init() {
		logger.info("ApiService.init()");
		addCountry("USA");
		addCountry("RUSSIA");
		addCity("Los Angeles", "USA", 10000L);
		addCity("New York", "USA", 20000L);
		addCity("Washington", "USA", 30000L);
		addCity("Moscow", "RUSSIA", 90000L);
		addCity("Novosibirsk", "RUSSIA", 10000L);

		// 結合済みのEntity Model
		addCityCountry("Los Angeles", "USA", 10000L);
		addCityCountry("New York", "USA", 20000L);
		addCityCountry("Washington", "USA", 30000L);
		addCityCountry("Moscow", "RUSSIA", 90000L);
		addCityCountry("Novosibirsk", "RUSSIA", 10000L);
	}
}
