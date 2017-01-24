package com.example.sbjasperangular.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.Shop;
import com.example.sbjasperangular.cassandra.repository.ShopRepository;



@Service
@Transactional
public class ShopService {

	@Autowired
	ShopRepository repository;

	public Iterable<Shop> findAll() {
		return repository.findAll();
	}

	public List<Shop> findAllOrderBySId() {
		return repository.findAllOrderBySId();
	}

	public Shop findOne(String name) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findBySId(name);
	}

	public Shop create(Shop obj) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(obj);
	}

	public Shop update(Shop obj) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(obj);
	}

	public void delete(String name) {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteBySId(name);
	}

}
