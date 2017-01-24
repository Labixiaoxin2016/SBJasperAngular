package com.example.sbjasperangular.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sbjasperangular.cassandra.model.Shop;

@Repository
public interface ShopRepository extends CassandraRepository<Shop> {


	@Query("SELECT * FROM shop where pkey1='a' and pkey2='b' ORDER BY s_id LIMIT ?0")
    List<Shop> findAllOrderBySId(int limit);

	@Query("SELECT * FROM shop where pkey1='a' and pkey2='b' ORDER BY s_id")
    List<Shop> findAllOrderBySId();

//	@Query("SELECT * FROM shop WHERE name=?0")
	@Query("SELECT * FROM shop WHERE pkey1='a' and pkey2='b' and s_id=?0")
	public Shop findBySId(String s);

	@Query("SELECT * FROM shop WHERE pkey1='a' and pkey2='b' and s_name=?0")
	public List<Shop> findBySName(String s);


//	@Query("DELETE FROM shop WHERE name=?0")
	@Query("DELETE FROM shop WHERE pkey1='a' and pkey2='b' and s_id=?0")
	public List<Shop> deleteBySId(String s);


}