package com.example.sbjasperangular.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.sbjasperangular.model.MemoBox;



@RepositoryRestResource(collectionResourceRel = "all", path = "memobox")
public interface MemoBoxlRepository extends CrudRepository<MemoBox, Integer> {

}
