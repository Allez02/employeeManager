package com.employeemanager.employeeManager.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
public class UsersModels implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        setId(id);
    }

    private String username;

    private String password;

    private String name;

    private String surname;

    private String patronymic;

    private String phone;

    @ManyToOne
    @JoinColumn(name = "position_id")
    public PositionModels position;

    public String getPhone() {
        return phone;
    }



    public PositionModels getPosition() {
        return position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public void setPosition(PositionModels position) {
        this.position = position;
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

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(position);
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String GetFOI() {
        return this.patronymic + " " + this.name + " " + this.surname;
    }
}
