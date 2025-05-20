package com.fm.app.controller;

import java.util.ArrayList;
import java.util.List;

public class Card {

    /// <summary>
    /// ID of the Card as Integer
    /// </summary>
    public int Id ;

    /// <summary>
    /// Name of the Card as String
    /// </summary>
    public String name ;

    /// <summary>
    /// Description of the Card as String
    /// </summary>
    public String description ;

    /// <summary>
    /// Attack Value of the Card as Integer
    /// </summary>
    public int attack ;

    /// <summary>
    /// Defense Value of the Card as Integer
    /// </summary>
    public int defense ;

    /// <summary>
    /// Attribute of the Card as Integer
    /// </summary>
    public int attribute ;

    /// <summary>
    /// Level of the Card as Integer
    /// </summary>
    public int level ;

    /// <summary>
    /// Type of the Card as Integer
    /// </summary>
    public int type ;

    /// <summary>
    /// Guardian Star 1 of the Card as Integer
    /// </summary>
    public int guardianStar1 ;

    /// <summary>
    /// Guardian Star 2 of the Card as Integer
    /// </summary>
    public int guardianStar2 ;
    public Starchips Starchips;

    /// <summary>
    /// Fusions of the Card as a List
    /// </summary>
    public List<Fusion> Fusions = new ArrayList<>();

    /// <summary>
    /// Equips of the Card as a List
    /// </summary>
    public List<Integer> Equips = new ArrayList<>();

    public void addFusion(Fusion fusion) {
        Fusions.add(fusion);
    }

    public void addEquip(int i) {
        Equips.add(i);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGuardianStar1() {
        return guardianStar1;
    }

    public void setGuardianStar1(int guardianStar1) {
        this.guardianStar1 = guardianStar1;
    }

    public int getGuardianStar2() {
        return guardianStar2;
    }

    public void setGuardianStar2(int guardianStar2) {
        this.guardianStar2 = guardianStar2;
    }

    public List<Fusion> getFusions() {
        return Fusions;
    }

    public void setFusions(List<Fusion> fusions) {
        Fusions = fusions;
    }

    public List<Integer> getEquips() {
        return Equips;
    }

    public void setEquips(List<Integer> equips) {
        Equips = equips;
    }

    public void setStarchip(Starchips sc) {
        this.Starchips=sc;
    }
}
