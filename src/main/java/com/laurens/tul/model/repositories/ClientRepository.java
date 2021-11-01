package com.laurens.tul.model.repositories;

import com.laurens.tul.model.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Interface creada para hacer uso de la clase JPA Repository y todos los metodos de la misma, con el objeto Client
 */

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Client p WHERE p.id = :id")
    void deleteClientById(@Param("id") Long id);
}
