package br.compasso.uol.desafiospringboot.repository;

import br.compasso.uol.desafiospringboot.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
