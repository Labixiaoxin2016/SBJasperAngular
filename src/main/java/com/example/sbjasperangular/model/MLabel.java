package com.example.sbjasperangular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MLabel implements Serializable {
    private static final long serialVersionUID = 7215298992738155752L;

    @Id
    @Column(name="label_id")
    private int labelId;

    @Column(name="label_name")
    private String labelName;

    @Column(name="parent_label_id")
    private int parentLabelId;



}
