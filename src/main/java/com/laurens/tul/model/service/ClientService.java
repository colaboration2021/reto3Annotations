package com.laurens.tul.model.service;

import com.laurens.tul.model.entities.Client;
import com.laurens.tul.model.repositories.ClientRepository;
import com.laurens.tul.model.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


// Servicio creado para la entidad Producto, el cual realiza las acciones de consulta al repositorio


@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final MessageRepository messageRepository;

    //Se inyectan las dependencias en el constructor
    @Autowired
    public ClientService(ClientRepository clientRepository, MessageRepository reservationDetailRepository) {
        this.clientRepository = clientRepository;
        this.messageRepository = reservationDetailRepository;
    }


     /** Metodo encargado de agregar un nuevo producto, recibe como parametro el objeto Producto
     * @param client
     * @return
     */
    public Client addNewClient(Client client){
        return clientRepository.save(client);
    }

     /**
     * Metodo encargado de consultar todos los productos de la BD
     * @return List<Product> devuelve una lista de todos los productos
     */
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

     /** Metodo encargado de obtener un producto dado un ID de producto.
     * @param id
     * @return
     */

    public Optional<Client> getClient(Long id){
        return clientRepository.findById(id);
    }

     /** Metodo encargado de actualizar la información de un producto en BD.
     * @param client
     * @return
     */

    @Transactional
    public Client updateClient(Client client){
        clientRepository.findById(client.getId()).orElseThrow( () -> new IllegalStateException(
                "This ID product does not exist" ) );
        return clientRepository.save(client);
    }

    /**
     * Metodo encargado de eliminar un producto en BD. Se valida que el producto
     * no tenga conexion con otra entidad, para no romper con la integridad de los datos
     * @param id
     * @return
     */
    @Transactional
    public HttpStatus deleteClient(Long id){
        if(messageRepository.selectMessageFromClientId(id).isEmpty() ){
            clientRepository.deleteById(id);
            return HttpStatus.OK;
        } else {
            return HttpStatus.CONFLICT;
        }
    }

}
