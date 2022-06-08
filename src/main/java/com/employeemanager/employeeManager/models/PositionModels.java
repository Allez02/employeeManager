package com.employeemanager.employeeManager.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
public class PositionModels implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private int zp;

    private float premium;

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
