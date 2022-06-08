package com.employeemanager.employeeManager.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
public class UsersModels implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String username;

    private String password;

    private String name;

    private String surname;

    private String patronymic;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "position_id")
    public PositionModels position;



    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }



    public UsersModels() {

    }

    public UsersModels(Long id, String username, String password, String name, String surname, String patronymic, String phone, PositionModels position) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.phone = phone;
        this.position = position;
    }

    public UsersModels(String username, String password, PositionModels position) {
        this.username = username;
        this.password = password;
        this.name = "";
        this.surname = "";
        this.patronymic = "";
        this.phone = "";
        this.position = position;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(position);
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String GetFOI() {
        return this.patronymic + " " + this.name + " " + this.surname;
    }
}
