package com.example.sbjasperangular.cassandra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.Person;
import com.example.sbjasperangular.cassandra.repository.PersonRepository2;



@Service
@Transactional
/**
 * https://github.com/hidetarou2013/spring-data-examples/tree/master/cassandra/java8/src/main/java/example/springdata/cassandra/java8
 *
 * @author maekawa
 *
 */
public class PersonService2 {

	@Autowired
	PersonRepository2 repository;

	public Iterable<Person> findAll() {
//		return repository.findAllOrderByName();
		return repository.findAll();
	}

	public Person findByPerson(Person p) {
		String id = p.getId();
		return repository.findOne(id);
	}

	public Person findOne(String id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findOne(id);
	}

	public Person create(Person p) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(p);
	}

	public Person update(Person p) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(p);
	}

	public void deleteAll() {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteAll();
	}

	public void delete(String id) {
		// TODO 自動生成されたメソッド・スタブ
		repository.delete(id);
	}

}
