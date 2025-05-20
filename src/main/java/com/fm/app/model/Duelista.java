package com.fm.app.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Duelista {
    @Id
    private Integer id;
    private String nome;

    @OneToMany(mappedBy = "duelista")
    private Set<Drops> drops;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Drops> getDropss() {
        return drops;
    }

    public void setDropss(Set<Drops> drops) {
        this.drops = drops;
    }
}
