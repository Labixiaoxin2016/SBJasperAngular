package com.example.sbjasperangular.cassandra.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.CassandraMLabel;
import com.example.sbjasperangular.cassandra.repository.CassandraMLabelRepository;



@Service
@Transactional
public class CassandraMLabelService {

	@Autowired
	CassandraMLabelRepository repository;

	public List<CassandraMLabel> findAll() {
		Iterable<CassandraMLabel> iteMLabel = repository.findAll();
//		Iterator<CassandraMLabel> ite1 = iteMLabel.iterator();
//		return repository.findAll();

		return StreamSupport.stream(iteMLabel.spliterator(), false)
        .collect(Collectors.toList());

	}

	public CassandraMLabel findByLabelName(String name) {
		return repository.findByLabelName(name);
	}


}
