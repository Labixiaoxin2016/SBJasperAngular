package com.example.sbjasperangular.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sbjasperangular.cassandra.model.CassandraCity;

@Repository
public interface CassandraCityRepository extends CassandraRepository<CassandraCity> {


	@Query("SELECT * FROM cassandra_city where pkey1='a' and pkey2='b' ORDER BY name")
    List<CassandraCity> findAllOrderByName();

//	@Query("SELECT * FROM cassandra_city WHERE name=?0")
	@Query("SELECT * FROM cassandra_city WHERE pkey1='a' and pkey2='b' and name=?0")
	public CassandraCity findByName(String s);

	@Query("SELECT * FROM cassandra_city WHERE pkey1='a' and pkey2='b' and population=?0")
	public List<CassandraCity> findByPopulation(String s);


//	@Query("DELETE FROM cassandra_city WHERE name=?0")
	@Query("DELETE FROM cassandra_city WHERE pkey1='a' and pkey2='b' and name=?0")
	public List<CassandraCity> deleteByName(String s);


//	@Query("SELECT * FROM cassandra_city WHERE name=?0 LIMIT ?1")
	@Query("SELECT * FROM cassandra_city WHERE pkey1='a' and pkey2='b' and country_id=?0")
    Iterable<CassandraCity> findByCountryId(String name);


}