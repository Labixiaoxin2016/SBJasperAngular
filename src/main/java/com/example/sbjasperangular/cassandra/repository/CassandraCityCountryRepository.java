package com.example.sbjasperangular.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sbjasperangular.cassandra.model.CassandraCityCountry;

@Repository
public interface CassandraCityCountryRepository extends CassandraRepository<CassandraCityCountry> {


	@Query("SELECT * FROM cassandra_city_country where pkey1='a' and pkey2='b' ORDER BY name")
    List<CassandraCityCountry> findAllOrderByName();

//	@Query("SELECT * FROM cassandra_city_country WHERE name=?0")
	@Query("SELECT * FROM cassandra_city_country WHERE pkey1='a' and pkey2='b' and name=?0")
	public List<CassandraCityCountry> findByName(String s);

	@Query("SELECT * FROM cassandra_city_country WHERE pkey1='a' and pkey2='b' and population=?0")
	public List<CassandraCityCountry> findByPopulation(String s);


//	@Query("DELETE FROM cassandra_city_country WHERE name=?0")
	@Query("DELETE FROM cassandra_city_country WHERE pkey1='a' and pkey2='b' and name=?0")
	public List<CassandraCityCountry> deleteByName(String s);


//	@Query("SELECT * FROM cassandra_city_country WHERE name=?0 LIMIT ?1")
	@Query("SELECT * FROM cassandra_city_country WHERE pkey1='a' and pkey2='b' and name=?0 LIMIT ?1")
    Iterable<CassandraCityCountry> findByName(String name,Integer limit);


}