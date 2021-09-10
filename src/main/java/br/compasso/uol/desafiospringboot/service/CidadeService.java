package br.compasso.uol.desafiospringboot.service;

import br.compasso.uol.desafiospringboot.model.Cidade;
import br.compasso.uol.desafiospringboot.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {


    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade addCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }
}
