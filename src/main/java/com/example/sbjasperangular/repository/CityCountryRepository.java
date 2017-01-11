package com.example.sbjasperangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.sbjasperangular.model.CityCountry;



@Repository
public interface CityCountryRepository extends CrudRepository<CityCountry, String> {

}
