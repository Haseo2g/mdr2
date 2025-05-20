package com.fm.app.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Equipamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equip")
    private Carta equip;

    @ManyToOne
    @JoinColumn(name = "monstro")
    private Carta monstro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carta getEquip() {
        return equip;
    }

    public void setEquip(Carta equip) {
        this.equip = equip;
    }

    public Carta getMonstro() {
        return monstro;
    }

    public void setMonstro(Carta monstro) {
        this.monstro = monstro;
    }
}
