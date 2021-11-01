package com.laurens.tul.model.service;

import com.laurens.tul.model.entities.Message;
import com.laurens.tul.model.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio creado para la entidad ReservationService, el cual realiza las acciones de consulta al repositorio
 */
@Service
public class MessageService {

    //Se instancia el objeto repositorio
    private final MessageRepository messageRepository;

    //Se inyecta la dependencia en el constructor del servicio
    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


     // Metodo encargado de añadir el detalle del producto por cada producto en una compra
     // @param purchaseDetail
     // @return

    public Message addNewMessage(Message message){
        return messageRepository.save(message);
    }

    /**
     * Metodo encargado de obtener el detalle de todos los productos de una compra
     * @return
     */
    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    }

}
