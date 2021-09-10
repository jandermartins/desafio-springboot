package br.compasso.uol.desafiospringboot.controller;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
public class Cidade {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String estado;

    public Cidade() {

    }

    public Cidade(String nome, String estado) {
        this.nome = nome;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
