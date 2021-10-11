package br.compasso.uol.desafiospringboot.service;

import br.compasso.uol.desafiospringboot.model.Cliente;
import br.compasso.uol.desafiospringboot.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente addCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente getClienteById2(Long id){
        return clienteRepository.findClienteById(id);
    }

    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Cliente editCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getClientePeloNome(String nome) {
        return clienteRepository.findByNome(nome);
    }

    public void deleteClienteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
