package com.laurens.tul.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Audience {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private int id;
    private String owner;
    private String name;
    private int capacity;
    private String description;

    public Audience() {
    }

    public Audience(int id, String owner, String name, int capacity, String description) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.capacity = capacity;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

