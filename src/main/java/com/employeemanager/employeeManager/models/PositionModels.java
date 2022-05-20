package com.employeemanager.employeeManager.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class PositionModels implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int zp;

    private float premium;

    public float getPremium() {return premium;}

    public void setPremium(float premium) {this.premium = premium;}

    public void setId(Long id) {
        setId(id);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setZp(int salary) {
        this.zp = salary;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getZp() {
        return this.zp;
    }

    public PositionModels() {

    }

    public PositionModels(Long id, String name, String description, int zp, float premium) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.zp = zp;
        this.premium = premium;
    }

    public float GetAllZp() {
        return zp + (zp * premium);
    }
    @Override
    public String getAuthority() {
        return name;
    }
}
