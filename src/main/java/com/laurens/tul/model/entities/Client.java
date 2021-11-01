package com.laurens.tul.model.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/*
 * Clase en JAVA que prepsenta la entidad "Client" en la BD.
 */
@Entity
@Table
public class Client implements Serializable {

    //Se definen las columnas de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotNull
    @DecimalMin("1")
    private Long sku;
    @NotEmpty(message = "El campo Name no puede llegar vacio.")
    private String name;
    private String email;
    @NotNull
    private String password;
    @Transient
    private Integer age;

    //Default Constructor
    public Client() {
    }

    //Full constructor
    public Client(Long sku, String name, String email, String password, Integer age) {
        this.sku = sku;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku=" + sku +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", age=" + age +
                '}';
    }

}