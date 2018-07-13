package com.example.jackson.springjpajackson;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.Private.class)
    private Integer id;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private String message;

    public User() {
    }

    public User(Integer id, String name, String message) {
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public User(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
