package com.example.sbjasperangular.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbjasperangular.cassandra.model.Shop;

@RestController
@RequestMapping("rest/cassandra/shop")
public class ShopRestController {

	@Autowired
	ShopService service;

	// curl http://localhost:8080/rest/cassandra/shop -i -XGET
	// OK
	@GetMapping
	List<Shop> getShopAll() {
//        Stream<Person> st = service.findAll();
//        return st.collect(Collectors.toList());
        return service.findAllOrderBySId();
    }

}
