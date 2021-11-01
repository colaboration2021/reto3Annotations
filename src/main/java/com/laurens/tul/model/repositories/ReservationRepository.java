package com.laurens.tul.model.repositories;

import com.laurens.tul.model.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface creada para hacer uso de la clase JPA Repository y todos los metodos de la misma, con el objeto Repository
 */

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
