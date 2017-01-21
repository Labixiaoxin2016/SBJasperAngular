package com.example.sbjasperangular.cassandra.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.sbjasperangular.cassandra.model.CassandraCity;

@RepositoryRestResource(collectionResourceRel = "all", path = "rest_resource_city")
public interface CityRepositoryRestCassandra extends CassandraRepository<CassandraCity> {
/*
	// curl http://localhost:8080/rest/rest_resource_city -i -XGET
	// curl http://localhost:8080/rest_repository/rest_resource_city -i -XGET

	@Query("SELECT * FROM city_country where pkey1='a' and pkey2='b' ORDER BY name")
    List<CityCountry> findAllOrderByName();

//	@Query("SELECT * FROM city_country WHERE name=?0")
	@Query("SELECT * FROM city_country WHERE pkey1='a' and pkey2='b' and name=?0")
	public List<CityCountry> findByName(String s);

	@Query("SELECT * FROM city_country WHERE pkey1='a' and pkey2='b' and population=?0")
	public List<CityCountry> findByPopulation(String s);


//	@Query("DELETE FROM city_country WHERE name=?0")
	@Query("DELETE FROM city_country WHERE pkey1='a' and pkey2='b' and name=?0")
	public List<CityCountry> deleteByName(String s);


//	@Query("SELECT * FROM city_country WHERE name=?0 LIMIT ?1")
	@Query("SELECT * FROM city_country WHERE pkey1='a' and pkey2='b' and name=?0 LIMIT ?1")
    Iterable<CityCountry> findByName(String name,Integer limit);

*/
}