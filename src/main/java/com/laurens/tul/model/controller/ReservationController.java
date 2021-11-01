package com.laurens.tul.model.controller;

import com.laurens.tul.model.entities.Reservation;
import com.laurens.tul.model.service.ReservationService;
import com.laurens.tul.utilities.Status;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


/**
 * Clase controlador, creada para manejar los endpoints de la entidad Purchase.
 *
 */
@RestController
@RequestMapping(path = "api/Reservations")
public class ReservationController {

    //Se crea una instancia del servicio que consulta la info en BD.

    private ReservationService reservationService;

    //Se inyecta la dependencia del servicio al constructor del controlador.
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * ENDPOINTS
     */

    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") Long id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> addNewReservation(@Valid @RequestBody Reservation reservation) {
        reservation.setStatus(Status.PENDIENTE);
        System.out.println("Reservation object: "+ reservation.getMessageReservation().toString());
        return new ResponseEntity<Reservation>(reservationService.addNewReservation(reservation), HttpStatus.OK);
    }

}
