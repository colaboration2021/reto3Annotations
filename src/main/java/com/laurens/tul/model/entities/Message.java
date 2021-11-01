package com.laurens.tul.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

/**
 * Clase en JAVA que representa la entidad "message" en la BD.
 */
@Entity
public class Message{

    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private @NotNull  Client client;

    @JsonIgnore
    @ManyToOne
    private @NotNull Reservation reservation;

    @NotNull
    @DecimalMin("1")
    private Integer quantity;
    @NotNull
    @DecimalMin("1")
    private Double value;

    public Message() {
    }

    public Message(Long id, Reservation reservation, Client client, Integer quantity, Double value){
        this.id = id;
        this.client = client;
        this.reservation = reservation;
        this.quantity = quantity;
        this.value = value;
    }

    public Message(Client client, Reservation reservation, Integer quantity, Double value) {
        this.client = client;
        this.reservation = reservation;
        this.quantity = quantity;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PurchaseDetail{" +
                "id=" + id +
                ", client=" + client +
                ", reservation=" + reservation +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }
}
