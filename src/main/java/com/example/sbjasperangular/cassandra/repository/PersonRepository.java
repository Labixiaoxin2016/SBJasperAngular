package com.example.sbjasperangular.cassandra.repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.sbjasperangular.cassandra.model.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
	/**
	 * Special customization of {@link CrudRepository#findOne(java.io.Serializable)} to return a JDK 8 {@link Optional}.
	 *
	 * @param id
	 * @return
	 */
	Person findOne(String id);

	@Query("select * from person")
	List<Person> streamAllPeople();

	/**
	 * Sample method to derive a query from using JDK 8's {@link Optional} as return type.
	 *
	 * @param id
	 * @return
	 */
	@Query("select * from person where id = ?0")
	Person findById(String id);

	/**
	 * Sample default method to show JDK 8 feature support.
	 *
	 * @param person
	 * @return
	 */
	default Person findByPerson(Person person) {
		return findById(person == null ? null : person.id);
	}

	void deleteAll();

	Person save(Person person);
}
