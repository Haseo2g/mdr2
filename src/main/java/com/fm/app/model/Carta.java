package com.fm.app.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Carta {

    @Id
    private Integer id;
    private String nome;
    private String cardType;
    @Enumerated(EnumType.ORDINAL)
    private TYPE type;
    @Enumerated(EnumType.ORDINAL)
    private GUARDIAN_STAR guardianStar1;
    @Enumerated(EnumType.ORDINAL)
    private GUARDIAN_STAR guardianStar2;
    private String level;
    private String atk;
    private String def;
    private String password;
    private String starchipCost;
    private String description;
    @OneToMany(mappedBy = "carta")
    private Set<Drops> drops;

    public int getTypeOrdinal() {
        return type != null ? type.ordinal() : -1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public GUARDIAN_STAR getGuardianStar1() {
        return guardianStar1;
    }

    public void setGuardianStar1(GUARDIAN_STAR guardianStar1) {
        this.guardianStar1 = guardianStar1;
    }

    public GUARDIAN_STAR getGuardianStar2() {
        return guardianStar2;
    }

    public void setGuardianStar2(GUARDIAN_STAR guardianStar2) {
        this.guardianStar2 = guardianStar2;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAtk() {
        return atk;
    }

    public void setAtk(String atk) {
        this.atk = atk;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStarchipCost() {
        return starchipCost;
    }

    public void setStarchipCost(String starchipCost) {
        this.starchipCost = starchipCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Drops> getDropss() {
        return drops;
    }

    public void setDropss(Set<Drops> drops) {
        this.drops = drops;
    }

    public enum GUARDIAN_STAR {
        NONE("None"), 
        MARS("Mars"), 
        JUPITER("Jupiter"),
        SATURN("Saturn"),
        URANUS("Uranus"),
        PLUTO("Pluto"), 
        NEPTUNE("Neptune"),
        MERCURY("Mercury"),
        SUN("Sun"), 
        MOON("Moon"),
        VENUS("Venus");
        private final String name;

        GUARDIAN_STAR(String nome) {
            this.name = nome;
        }

        public String getName() {
            return name;
        }
    }

    public enum TYPE {
        DRAGON("Dragon"), 
        SPELLCASTER("Spellcaster"), 
        ZOMBIE("Zombie"), 
        WARRIOR("Warrior"), 
        BEAST_WARRIOR("Beast Warrior"), 
        BEAST("Beast"),
        WINGED_BEAST("Winged Beast"),
        FIEND("Fiend"),
        FAIRY("Fairy"),
        INSECT("Insect"), 
        DINOSAUR("Dinosaur"), 
        REPTILE("Reptile,"), 
        FISH("Fish"),
        SEA_SERPENT("Sea Serpent"),
        MACHINE("Machine"),
        THUNDER("Thunder"), 
        AQUA("Aqua"),
        PYRO("Pyro"), 
        ROCK("Rock"), 
        PLANT("Plant"),
        MAGIC("Magic"), 
        TRAP("Trap"), 
        RITUAL("Ritual"), 
        EQUIP("Equip");
        private final String name;

        TYPE(String nome) {
            this.name = nome;
        }

        public String getName() {
            return name;
        }
    }
}
