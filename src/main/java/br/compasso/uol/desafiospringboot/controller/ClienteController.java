package br.compasso.uol.desafiospringboot.controller;

import br.compasso.uol.desafiospringboot.model.Cliente;
import br.compasso.uol.desafiospringboot.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente addCliente(@RequestBody Cliente cliente){
        return clienteService.addCliente(cliente);
    }
}
