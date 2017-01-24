package com.example.sbjasperangular.cassandra.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.sbjasperangular.cassandra.model.Sales;

// CassandraRepository CrudRepository<Sales,SalesKeyId>
@Repository
public interface SalesRepository extends CassandraRepository<Sales> {


	@Query("SELECT * FROM sales where pkey1='a' and pkey2='b' ORDER BY s_id,s_date LIMIT ?0")
    List<Sales> findAllOrderBySId(int limit);

	@Query("SELECT * FROM sales where pkey1='a' and pkey2='b' ORDER BY s_id,s_date")
    List<Sales> findAllOrderBySId();

//	@Query("SELECT * FROM sales WHERE name=?0")
	@Query("SELECT * FROM sales WHERE pkey1='a' and pkey2='b' and s_id=?0 and s_date=?1")
	public Sales findBySIdAndSDate(String s,String s2);

	@Query("SELECT * FROM sales WHERE pkey1='a' and pkey2='b' and s_value=?0")
	public List<Sales> findBySValue(String s);


//	@Query("DELETE FROM sales WHERE name=?0")
	@Query("DELETE FROM sales WHERE pkey1='a' and pkey2='b' and s_id=?0 and s_date=?1")
	public List<Sales> deleteBySIdAndSDate(String s,String s2);


}