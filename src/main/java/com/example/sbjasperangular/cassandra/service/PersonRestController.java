package com.example.sbjasperangular.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbjasperangular.cassandra.model.Person;

@RestController
@RequestMapping("rest/cassandra/person")
public class PersonRestController {

	@Autowired
	PersonService service;

	// curl http://localhost:8080/rest/cassandra/person -i -XGET
	// curl http://localhost:8080/rest/cassandra/person -i -XGET
	// OK
	@GetMapping
	List<Person> getPersonAll() {
//        Stream<Person> st = service.findAll();
//        return st.collect(Collectors.toList());
        return service.findAll();
    }

}
