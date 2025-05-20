package com.fm.app.repository;

import com.fm.app.model.Equipamento;
import com.fm.app.model.Fusao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer> {
    @Query("""
    SELECT e FROM Equipamento e
    JOIN FETCH e.equip
    JOIN FETCH e.monstro
    WHERE e.equip.id = :equip
    """)
    List<Equipamento> findEquipableCards(@Param("equip") Integer equip);

    @Query("""
    SELECT e FROM Equipamento e
    JOIN FETCH e.equip
    JOIN FETCH e.monstro
    WHERE e.monstro.id = :monster
    """)
    List<Equipamento> findEquipCards(@Param("monster") Integer monster);
}
