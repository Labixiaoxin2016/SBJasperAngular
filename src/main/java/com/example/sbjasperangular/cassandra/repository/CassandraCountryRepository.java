package com.example.sbjasperangular.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sbjasperangular.cassandra.model.CassandraCountry;

@Repository
public interface CassandraCountryRepository extends CassandraRepository<CassandraCountry> {


	@Query("SELECT * FROM cassandra_country where pkey1='a' and pkey2='b' ORDER BY id")
    List<CassandraCountry> findAllOrderById();

//	@Query("SELECT * FROM cassandra_country WHERE id=?0")
	@Query("SELECT * FROM cassandra_country WHERE pkey1='a' and pkey2='b' and id=?0")
	public CassandraCountry findById(String s);


//	@Query("DELETE FROM cassandra_country WHERE name=?0")
	@Query("DELETE FROM cassandra_country WHERE pkey1='a' and pkey2='b' and id=?0")
	public List<CassandraCountry> deleteById(String s);




}