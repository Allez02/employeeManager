package com.employeemanager.employeeManager.models;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ads")
public class AdsModels implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String text;

    public AdsModels() {}

    public AdsModels( String name, String text) {
        this.name = name;
        this.text = text;
    }





}
