package com.example.sbjasperangular.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.Sales;
import com.example.sbjasperangular.cassandra.repository.SalesRepository;



@Service
@Transactional
public class SalesService {

	@Autowired
	SalesRepository repository;

	public Iterable<Sales> findAll() {
		return repository.findAll();
	}

	public List<Sales> findAllOrderBySId() {
		return repository.findAllOrderBySId();
	}

	public Sales findOne(String s,String s2) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findBySIdAndSDate(s,s2);
	}

	public Sales create(Sales obj) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(obj);
	}

	public Sales update(Sales obj) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(obj);
	}

	public void delete(String s,String s2) {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteBySIdAndSDate(s,s2);
	}

}
