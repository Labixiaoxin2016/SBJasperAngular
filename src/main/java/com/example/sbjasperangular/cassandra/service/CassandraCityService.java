package com.example.sbjasperangular.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.CassandraCity;
import com.example.sbjasperangular.cassandra.repository.CassandraCityRepository;



@Service
@Transactional
public class CassandraCityService {

	@Autowired
	CassandraCityRepository repository;

	public Iterable<CassandraCity> findAll() {
		return repository.findAll();
	}

	public List<CassandraCity> findAllByName() {
		return repository.findAllOrderByName();
	}

	public CassandraCity findOne(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findByName(name);
	}

	public CassandraCity create(CassandraCity obj) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(obj);
	}

	public CassandraCity update(CassandraCity obj) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(obj);
	}

	public void delete(String name) {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteByName(name);
	}

	public Iterable<CassandraCity> findByCountryId(String country_id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findByCountryId(country_id);
	}

}
