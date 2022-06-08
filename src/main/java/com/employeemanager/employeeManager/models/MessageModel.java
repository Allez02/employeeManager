package com.employeemanager.employeeManager.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "message_model")
@Data
public class MessageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Date date = new Date();


    @ManyToOne
    private UsersModels autor;


    public MessageModel () {

    }

    public MessageModel(Date date, String text, UsersModels autor) {
        this.date = date;
        this.autor = autor;
        this.text = text;
    }
}
