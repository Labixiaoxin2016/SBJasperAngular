package com.example.sbjasperangular.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sbjasperangular.cassandra.model.CassandraMLabel;

@Repository
public interface CassandraMLabelRepository extends CassandraRepository<CassandraMLabel> {


	@Query("SELECT * FROM M_LABEL where pkey1='autobacks' and pkey2='kokyaku'")
    List<CassandraMLabel> findAll();

//	@Query("SELECT * FROM M_LABEL WHERE labelName=?0")
	@Query("SELECT * FROM M_LABEL WHERE pkey1='autobacks' and pkey2='kokyaku' and labelName=?0")
	public CassandraMLabel findByLabelName(String s);

//	@Query("SELECT * FROM M_LABEL WHERE pkey1='autobacks' and pkey2='kokyaku' and population=?0")
//	public List<CassandraMLabel> findByPopulation(String s);
//
//
////	@Query("DELETE FROM M_LABEL WHERE name=?0")
//	@Query("DELETE FROM M_LABEL WHERE pkey1='autobacks' and pkey2='kokyaku' and name=?0")
//	public List<CassandraMLabel> deleteByName(String s);
//
//
////	@Query("SELECT * FROM M_LABEL WHERE name=?0 LIMIT ?1")
//	@Query("SELECT * FROM M_LABEL WHERE pkey1='autobacks' and pkey2='kokyaku' and country_id=?0")
//    Iterable<CassandraMLabel> findByCountryId(String name);


}