package com.example.sbjasperangular.cassandra.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class CityCountry2KeyId implements Serializable {

  @Getter
  @Setter
  private String pkey1;

  @Getter
  @Setter
  private String pkey2;

  @Getter
  @Setter
  private String name;

}