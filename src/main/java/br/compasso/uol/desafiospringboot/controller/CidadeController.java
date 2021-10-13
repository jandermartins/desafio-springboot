package br.compasso.uol.desafiospringboot.controller;

import br.compasso.uol.desafiospringboot.model.Cidade;
import br.compasso.uol.desafiospringboot.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@CrossOrigin
@RequestMapping(value = "/cidade")
@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "{cidade}")
    public Cidade getCidadePeloNome(@PathVariable String cidade){
        return cidadeService.getCidadeByNome(cidade);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, value = "/estado/{estado}")
    public ResponseEntity<List<Cidade>> getCidadePeloEstado(@PathVariable String estado){
        return new ResponseEntity<List<Cidade>>((List<Cidade>) cidadeService.getCidadeByEstado(estado), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Cidade addCidade(@RequestBody Cidade cidade) {
        return cidadeService.addCidade(cidade);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cidade>> getCidades(){
        return new ResponseEntity<List<Cidade>>((List<Cidade>) cidadeService.getCidades(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value = "{id}")
    @ResponseBody
    public ResponseEntity<Cidade> editCidade(@RequestBody Cidade cidade, @PathVariable ("id") Integer id){
        if(cidadeService.getCidadeById(id) != null){
            cidade.setId(id);
            return new ResponseEntity<Cidade>(cidadeService.editCidade(cidade), HttpStatus.OK);
        }
        return null;
    }
}
