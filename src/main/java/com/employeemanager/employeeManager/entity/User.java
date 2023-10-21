package com.employeemanager.employeeManager.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String information;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    private Boolean isNonLocked;

    private Boolean isApproved;

    public User() {

    }

    public User(String username, String password, String name, String surname, String information, Role role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.information = information;
        this.role = role;
        this.isNonLocked = true;
        this.isApproved = false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(role);
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isApproved;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public void setIsNonLocked(Boolean isNonLocked) {
        this.isNonLocked = isNonLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
