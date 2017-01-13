package com.example.sbjasperangular.cassandra.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.sbjasperangular.cassandra.model.CityCountry2;

@RepositoryRestResource(collectionResourceRel = "all", path = "rest_resource_citycountry")
public interface CityCountryRepository2 extends CrudRepository<CityCountry2, String> {

	// curl http://localhost:8080/rest_repository/rest_resource_citycountry -i -XGET
}
