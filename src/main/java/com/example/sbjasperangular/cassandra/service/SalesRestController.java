package com.example.sbjasperangular.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbjasperangular.cassandra.model.Sales;

@RestController
@RequestMapping("rest/cassandra/sales")
public class SalesRestController {

	@Autowired
	SalesService service;

	// curl http://localhost:8080/rest/cassandra/sales -i -XGET
	// OK
	@GetMapping
	List<Sales> getSalesAll() {
//        Stream<Person> st = service.findAll();
//        return st.collect(Collectors.toList());
        return service.findAllOrderBySId();
    }

}
