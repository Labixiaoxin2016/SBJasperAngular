package com.example.sbjasperangular.cassandra.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.sbjasperangular.cassandra.model.Person;

@RepositoryRestResource(collectionResourceRel = "all", path = "rest_resource_person")
public interface PersonRepository2 extends CrudRepository<Person, String> {

	// curl http://localhost:8080/rest_repository/rest_resource_person -i -XGET
}
