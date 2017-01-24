package com.example.sbjasperangular.cassandra.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalesKeyId implements Serializable {

	private String sId;

	private String sDate;
}
