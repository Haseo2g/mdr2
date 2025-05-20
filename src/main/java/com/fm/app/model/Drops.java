package com.fm.app.model;

import jakarta.persistence.*;

@Entity
public class Drops {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Duelista duelista;

    @ManyToOne
    private Carta carta;

    @Enumerated(EnumType.ORDINAL)
    private CARD_ORIGIN rank;
    private int chance;

    public int getTypeOrdinal() {
        return rank != null ? rank.ordinal() : -1;
    }

    public enum CARD_ORIGIN {
        DECK("Deck"), SAPOW("SA Pow"), BCD("BCD"), SATEC("SA Tec");
        private final String name;

        CARD_ORIGIN(String nome) {
            this.name = nome;
        }

        public String getName() {
            return name;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Duelista getDuelista() {
        return duelista;
    }

    public void setDuelista(Duelista duelista) {
        this.duelista = duelista;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCarta(Carta carta) {
        this.carta = carta;
    }

    public CARD_ORIGIN getRank() {
        return rank;
    }

    public void setRank(CARD_ORIGIN rank) {
        this.rank = rank;
    }

    public int getChance() {
        return chance;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }
}
