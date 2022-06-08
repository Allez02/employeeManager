package com.employeemanager.employeeManager.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ads")
@Data
public class AdsModels {

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
