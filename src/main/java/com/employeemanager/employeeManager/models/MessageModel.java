package com.employeemanager.employeeManager.models;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "message_model")
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Date date = new Date();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAutor(UsersModels autor) {
        this.autor = autor;
    }

    @ManyToOne
    private UsersModels autor;

    public UsersModels getAutor() {
        return autor;
    }

    public MessageModel () {

    }

    public MessageModel(Date date, String text, UsersModels autor) {
        this.date = date;
        this.autor = autor;
        this.text = text;
    }
}
