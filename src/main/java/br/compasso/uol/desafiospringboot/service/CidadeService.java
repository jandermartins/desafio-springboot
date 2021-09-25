package br.compasso.uol.desafiospringboot.service;

import br.compasso.uol.desafiospringboot.model.Cidade;
import br.compasso.uol.desafiospringboot.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> getCidades(){
        return cidadeRepository.findAll();
    }


    public Cidade addCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public Cidade editCidade(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public Cidade getCidadeById(Integer id) {
        return cidadeRepository.findById(id);
    }
}
