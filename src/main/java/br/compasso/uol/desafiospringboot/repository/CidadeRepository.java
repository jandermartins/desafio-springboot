package br.compasso.uol.desafiospringboot.repository;

import br.compasso.uol.desafiospringboot.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Cidade findById(Integer id);

    Cidade getCidadeByNome(String cidade);

    List<Cidade> getCidadeByEstado(String estado);
}
