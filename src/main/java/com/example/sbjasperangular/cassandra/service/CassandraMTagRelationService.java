package com.example.sbjasperangular.cassandra.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sbjasperangular.cassandra.model.CassandraMTagRelation;
import com.example.sbjasperangular.cassandra.repository.CassandraMTagRelationRepository;



@Service
@Transactional
public class CassandraMTagRelationService {

	@Autowired
	CassandraMTagRelationRepository repository;

	public List<CassandraMTagRelation> findAll() {
		Iterable<CassandraMTagRelation> iteMLabel = repository.findAll();
//		Iterator<CassandraMTagRelation> ite1 = iteMLabel.iterator();
//		return repository.findAll();

		return StreamSupport.stream(iteMLabel.spliterator(), false)
        .collect(Collectors.toList());

	}

	public CassandraMTagRelation findByTaglName(String name) {
		return repository.findByTaglName(name);
	}


}
