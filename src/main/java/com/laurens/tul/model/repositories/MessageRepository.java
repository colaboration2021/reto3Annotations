package com.laurens.tul.model.repositories;

import com.laurens.tul.model.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Interface creada para hacer uso de la clase JPA Repository y todos los metodos de la misma, con el objeto PurchaseDetail
 */

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("SELECT pd FROM Message pd WHERE pd.client.id = :id")
    Optional<Message> selectMessageFromClientId(Long id);

}
