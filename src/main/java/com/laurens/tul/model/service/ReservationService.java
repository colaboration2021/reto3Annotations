package com.laurens.tul.model.service;

// import com.laurens.tul.model.entities.Message;
import com.laurens.tul.model.entities.Reservation;
import com.laurens.tul.model.repositories.MessageRepository;
import com.laurens.tul.model.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/*
 * Servicio creado para la entidad Purchase, el cual realiza las acciones de consulta al repositorio
 */
@Service
public class ReservationService {

    //Se instancian los objetos de repositorio a usar por el servicio
    private final ReservationRepository reservationRepository;
    private final MessageRepository messageRepository;

    //Se inyectan las dependencias al constructor del servicio
    @Autowired
    public ReservationService(ReservationRepository reservationRepository, MessageRepository messageRepository) {
        this.reservationRepository = reservationRepository;
        this.messageRepository = messageRepository;
    }


    /* Metodo encargado de añadir una reservacion.
    @param reservation
    @return
    */

    public Reservation addNewReservation(Reservation reservation){
        try{
            //Se registra la nueva compra en BD
            reservationRepository.save(reservation);
    /*

            //Se recorre la lista de clientes, para sacar el valor a aquellos productos que tienen descuento
            for (Message message : reservation.getMessageReservation()) {
                message.setReservation(reservation);
                message.setValue(
                        message.getClient().getDiscount()
                                ?  message.getQuantity() * ( message.getClient().getPrice() / 2 )
                                :  message.getQuantity() * ( message.getClient().getPrice() ));
                messageRepository.save(message);
            }
            reservation.setStatus(Status.COMPLETADO);
    */
            //Se actualiza la compra como COMPLETADA.
            return reservationRepository.save(reservation);
        }catch( Exception ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        return null;
    }

    /*
     * Metodo encargado de obtener todas las compras en BD
     * @return
     */

    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

    /*
     * Metodo encargado de obtener una compra dado un ID.
     * @param id
     * @return
     */

    public Optional<Reservation> getReservation(Long id){
        return reservationRepository.findById(id);
    }
}
