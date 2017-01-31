package com.example.sbjasperangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.sbjasperangular.model.MLabel;



@RepositoryRestResource(collectionResourceRel = "all", path = "m_label")
public interface MLabelRepository extends CrudRepository<MLabel, Integer> {

}
