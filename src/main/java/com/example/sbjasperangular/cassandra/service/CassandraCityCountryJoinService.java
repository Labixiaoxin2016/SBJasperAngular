package com.example.sbjasperangular.cassandra.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.CassandraCity;
import com.example.sbjasperangular.cassandra.model.CassandraCityCountry;
import com.example.sbjasperangular.cassandra.model.CassandraCountry;
import com.example.sbjasperangular.cassandra.repository.CassandraCityRepository;
import com.example.sbjasperangular.cassandra.repository.CassandraCountryRepository;



@Service
@Transactional
public class CassandraCityCountryJoinService {

	@Autowired
	CassandraCityRepository cityRepository;

	@Autowired
	CassandraCountryRepository countryRepository;

	public List<CassandraCityCountry> findAll() {
		Iterable<CassandraCity> iteCity = cityRepository.findAll();
		Iterable<CassandraCountry> iteCountry = countryRepository.findAll();
		List<CassandraCityCountry> iteCityCountry = new ArrayList<CassandraCityCountry>();
//		iteCity.forEach( (obj) -> {
//			String country_id = obj.getCountryId();
//
//			}
//		);
		Iterator<CassandraCity> ite1 = iteCity.iterator();
		LOOP_1:while(ite1.hasNext()){
			CassandraCity obj1 = ite1.next();
			String country_id = obj1.getCountryId();
			CassandraCityCountry obj3 = new CassandraCityCountry();
			obj3.setPkey1(obj1.getPkey1());
			obj3.setPkey2(obj1.getPkey2());
			obj3.setName(obj1.getName());
			obj3.setPopulation(obj1.getPopulation());
			Iterator<CassandraCountry> ite2 = iteCountry.iterator();
			LOOP_2:while(ite2.hasNext()){
				CassandraCountry obj2 = ite2.next();
				String country_name = "";
				if(country_id.equals(obj2.getId())){
					country_name = obj2.getName();
					obj3.setCountryName(country_name);
					iteCityCountry.add(obj3);
					break LOOP_2;
				}
			}
		}

		// dump
		iteCityCountry.forEach(o -> System.out.println(o.toString()));

		return iteCityCountry;
	}
//
//	public List<CassandraCity> findAllByName() {
//		return cityRepository.findAllOrderByName();
//	}
//
//	public CassandraCity findOne(String name) {
//		// TODO 自動生成されたメソッド・スタブ
//		return cityRepository.findByName(name);
//	}
//
//	public CassandraCity create(CassandraCity obj) {
//		// TODO 自動生成されたメソッド・スタブ
//		return cityRepository.save(obj);
//	}
//
//	public CassandraCity update(CassandraCity obj) {
//		// TODO 自動生成されたメソッド・スタブ
//		return cityRepository.save(obj);
//	}
//
//	public void delete(String name) {
//		// TODO 自動生成されたメソッド・スタブ
//		cityRepository.deleteByName(name);
//	}
//
//	public Iterable<CassandraCity> findByCountryId(String country_id) {
//		// TODO 自動生成されたメソッド・スタブ
//		return cityRepository.findByCountryId(country_id);
//	}

}
