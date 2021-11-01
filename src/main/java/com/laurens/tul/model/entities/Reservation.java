package com.laurens.tul.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.laurens.tul.utilities.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


 /** Clase en JAVA que representa la entidad "Reservation" en la BD.
 */
@Entity
public class Reservation implements Serializable {

    @Id
    @JsonProperty("id")
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date startDate;
    @NotNull
    private Date devolutionDate;
    //Se maneja el estado de la compra con un enumerable.
    private Status status;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reservation")
    private List<@NotNull Message> messageReservation;

    //Default constructor
    public Reservation(){
    }


    //Full Constructor
    public Reservation(Date startDate, Date devolutionDate, Status status, List<Client> clientList) {
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
    }

    /**
     * GETTERS AND SETTERS
     */


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReservationDate() {
        return startDate;
    }

    public void setReservationDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Message> getMessageReservation() {
        return messageReservation;
    }

    public void setMessageReservation(List<Message> messageReservation) {
        this.messageReservation = messageReservation;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", devolutionDate=" + devolutionDate +
                ", status=" + status +
                ", messageReservation=" + messageReservation +
                '}';
    }
}
