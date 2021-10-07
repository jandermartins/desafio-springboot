package br.compasso.uol.desafiospringboot.controller;

import br.compasso.uol.desafiospringboot.model.Cliente;
import br.compasso.uol.desafiospringboot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente addCliente(@RequestBody Cliente cliente){
        return clienteService.addCliente(cliente);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "{nome}")
    public ResponseEntity<List<Cliente>> getClientePeloNome(@PathVariable String nome){
        System.out.println(nome);
        return new ResponseEntity<List<Cliente>>((List<Cliente>) clienteService.getClientePeloNome(nome), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getClientes(){
        return new ResponseEntity<List<Cliente>>((List<Cliente>) clienteService.getClientes(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public ResponseEntity deleteCliente(@PathVariable("id") Long id){
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if(cliente != null){
            clienteService.deleteClienteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    @ResponseBody
    public ResponseEntity<Cliente> editCliente(@RequestBody Cliente cliente, @PathVariable ("id") Long id){
        if(clienteService.getClienteById(id) != null){
            cliente.setId(id);
            return new ResponseEntity<Cliente>(clienteService.editCliente(cliente), HttpStatus.OK);
        }
        if(clienteService.getClienteById(id) == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return null;
    }
}
