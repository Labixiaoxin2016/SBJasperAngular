package com.example.sbjasperangular.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.CassandraCountry;
import com.example.sbjasperangular.cassandra.repository.CassandraCountryRepository;



@Service
@Transactional
public class CassandraCountryService {

	@Autowired
	CassandraCountryRepository repository;

	public Iterable<CassandraCountry> findAll() {
		return repository.findAll();
	}

	public List<CassandraCountry> findAllById() {
		return repository.findAllOrderById();
	}

	public CassandraCountry findOne(String id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findById(id);
	}

	public CassandraCountry create(CassandraCountry obj) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(obj);
	}

	public CassandraCountry update(CassandraCountry obj) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(obj);
	}

	public void delete(String id) {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteById(id);
	}

}
