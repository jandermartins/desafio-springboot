package br.compasso.uol.desafiospringboot.repository;

import br.compasso.uol.desafiospringboot.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Cidade findById(Integer id);
}
