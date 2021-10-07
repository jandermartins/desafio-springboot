package br.compasso.uol.desafiospringboot.repository;

import br.compasso.uol.desafiospringboot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(Long id);

    List<Cliente> findByNome(String nome);

}
