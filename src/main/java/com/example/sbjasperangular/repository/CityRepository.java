package com.example.sbjasperangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.sbjasperangular.model.City;



@RepositoryRestResource(collectionResourceRel = "all", path = "city")
public interface CityRepository extends CrudRepository<City, String> {

}
