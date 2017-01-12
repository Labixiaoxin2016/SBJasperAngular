package com.example.sbjasperangular.cassandra.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.Person;
import com.example.sbjasperangular.cassandra.repository.PersonRepository;



@Service
@Transactional
/**
 * https://github.com/hidetarou2013/spring-data-examples/tree/master/cassandra/java8/src/main/java/example/springdata/cassandra/java8
 *
 * @author maekawa
 *
 */
public class PersonService {

	@Autowired
	PersonRepository repository;

	public Stream<Person> findAll() {
//		return repository.findAllOrderByName();
		return repository.streamAllPeople();
	}

	public Optional<Person> findByPerson(Person p) {
		return repository.findByPerson(p);
	}

	public Optional<Person> findOne(String id) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.findOne(id);
	}

	public Person create(Person memobox) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(memobox);
	}

	public Person update(Person memobox) {
		// TODO 自動生成されたメソッド・スタブ
		return repository.save(memobox);
	}

	public void deleteAll() {
		// TODO 自動生成されたメソッド・スタブ
		repository.deleteAll();
	}




}
