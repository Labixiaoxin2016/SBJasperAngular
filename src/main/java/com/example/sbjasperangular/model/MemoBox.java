package com.example.sbjasperangular.model;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "memobox")
public class MemoBox {


	@Id
	private int id;

	@Id
//	@Column(value = "name")
	private String name;

	@Column(value = "memo")
	private String memo;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@Column(value = "date")
	private Date date;


}
