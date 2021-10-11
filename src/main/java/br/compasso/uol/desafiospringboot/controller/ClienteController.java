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

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente addCliente(@RequestBody Cliente cliente){
        return clienteService.addCliente(cliente);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{nome}")
    public ResponseEntity<List<Cliente>> getClientePeloNome(@PathVariable String nome){
        System.out.println(nome);
        return new ResponseEntity<List<Cliente>>(clienteService.getClientePeloNome(nome), HttpStatus.OK);
    }

    @GetMapping(value = "/buscar/{id}")
    public Optional<Cliente> getClienteById(@PathVariable("id") Long id){
        return clienteService.getClienteById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cliente>> getClientes(){
        return new ResponseEntity<List<Cliente>>((List<Cliente>) clienteService.getClientes(), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity deleteCliente(@PathVariable("id") Long id){
        Optional<Cliente> cliente = clienteService.getClienteById(id);
        if(cliente != null){
            clienteService.deleteClienteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    @ResponseBody
    public ResponseEntity<Cliente> editCliente(@RequestBody Cliente cliente, @PathVariable ("id") Long id){

        Cliente cliente1 = clienteService.getClienteById2(id);

        cliente1.setNome(cliente.getNome());

        return new ResponseEntity<>(clienteService.editCliente(cliente1), HttpStatus.OK);


    }
}
