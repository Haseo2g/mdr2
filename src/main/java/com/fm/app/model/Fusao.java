package com.fm.app.model;

import jakarta.persistence.*;

@Entity
public class Fusao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "carta1")
    private Carta carta1;

    @ManyToOne
    @JoinColumn(name = "carta2")
    private Carta carta2;

    @ManyToOne
    @JoinColumn(name = "result")
    private Carta result;

    public Fusao() {
    }

    public Fusao(Carta carta1, Carta carta2, Carta result) {
        this.carta1 = carta1;
        this.carta2 = carta2;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carta getCarta1() {
        return carta1;
    }

    public void setCarta1(Carta carta1) {
        this.carta1 = carta1;
    }

    public Carta getCarta2() {
        return carta2;
    }

    public void setCarta2(Carta carta2) {
        this.carta2 = carta2;
    }

    public Carta getResult() {
        return result;
    }

    public void setResult(Carta result) {
        this.result = result;
    }
}