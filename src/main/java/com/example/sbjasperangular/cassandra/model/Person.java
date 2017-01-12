package com.example.sbjasperangular.cassandra.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	public String id;

	public String firstname;

	public String lastname;
}
