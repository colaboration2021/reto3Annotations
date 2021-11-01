package com.laurens.tul.model.controller;

import com.laurens.tul.model.entities.Client;
import com.laurens.tul.model.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Clase controlador, creada para manejar los endpoints de la entidad Producto.
 *
 */

@RestController
@RequestMapping(path = "api/Client")
public class ClientController {

    //Se crea una instancia de la clase servicio que va a manejar la conexion con los datos.
    private final ClientService clientService;

    //Se inyecta la dependencia del servicio al constructor del controlador.
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * ENDPOINTS
     * @return
     */
    @GetMapping
    public List<Client> getAllClient(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") Long id){
        return clientService.getClient(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Client> registerNewClient(@Valid @RequestBody Client client) {
        return new ResponseEntity<Client>(clientService.addNewClient(client), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteClient(@PathVariable("id") Long id){
        return clientService.deleteClient(id);
    }

    @PutMapping("/update")
    public void updateClient(@Valid @RequestBody Client client) {
        clientService.updateClient(client);
    }


}
