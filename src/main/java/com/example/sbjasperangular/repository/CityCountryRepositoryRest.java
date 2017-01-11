package com.example.sbjasperangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.sbjasperangular.model.CityCountry;


@RepositoryRestResource(collectionResourceRel = "all", path = "citycountry2")
public interface CityCountryRepositoryRest extends CrudRepository<CityCountry, String> {

}
