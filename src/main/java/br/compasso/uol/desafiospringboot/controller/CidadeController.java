package br.compasso.uol.desafiospringboot.controller;

import br.compasso.uol.desafiospringboot.model.Cidade;
import br.compasso.uol.desafiospringboot.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping(value = "/cidade")
@RestController()
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(method = RequestMethod.POST, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public Cidade addCidade(@RequestBody Cidade cidade){
        return cidadeService.addCidade(cidade);
    }
}
