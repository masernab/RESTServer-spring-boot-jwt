package com.miguel.springjwt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles") //Nombre de la coleccion en la DB
public class Role {
    @Id
    private String id;
    private ERole name;

    public Role() {
    }

    public Role(@JsonProperty("name") ERole name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
