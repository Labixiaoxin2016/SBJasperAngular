package com.example.sbjasperangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.sbjasperangular.model.Country;



@RepositoryRestResource(collectionResourceRel = "all", path = "country")
public interface CountryRepository extends CrudRepository<Country, String> {

}
