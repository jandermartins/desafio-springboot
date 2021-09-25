package br.compasso.uol.desafiospringboot.service;

import br.compasso.uol.desafiospringboot.model.Cliente;
import br.compasso.uol.desafiospringboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
}
