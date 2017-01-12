package com.example.sbjasperangular.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sbjasperangular.cassandra.model.CityCountry;

@Repository
public interface CityCountryRepository extends CassandraRepository<CityCountry> {


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


}