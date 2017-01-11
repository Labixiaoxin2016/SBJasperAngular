package com.example.sbjasperangular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {

    private static final long serialVersionUID = 3977347517121289291L;

    @Id
    private String name;

    @Column(nullable = false)
    private Long population;

    @ManyToOne
    private Country country;

// lombokを使うことで記載が減る。-------------------------------
//    public String getName() {
//	return name;
//    }
//
// setXXXの戻り値を自身の型にするやりかた→メソッドチェーンができる。
//    public City setName(String name) {
//	this.name = name;
//	return this;
//    }
//
//    public Long getPopulation() {
//	return population;
//    }
//
//    public City setPopulation(Long population) {
//	this.population = population;
//	return this;
//    }
//
//    public Country getCountry() {
//	return country;
//    }
//
//    public City setCountry(Country country) {
//	this.country = country;
//	return this;
//    }

}
