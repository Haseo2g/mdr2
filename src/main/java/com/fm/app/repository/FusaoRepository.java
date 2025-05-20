package com.fm.app.repository;

import com.fm.app.model.Carta;
import com.fm.app.model.Fusao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FusaoRepository extends JpaRepository<Fusao, Integer> {
    @Query("""
    SELECT f FROM Fusao f
    JOIN FETCH f.carta1
    JOIN FETCH f.carta2
    JOIN FETCH f.result
    WHERE f.carta1.id = :material OR f.carta2.id = :material
    """)
    List<Fusao> findByMaterial(@Param("material") Integer material);

    @Query("""
    SELECT f FROM Fusao f
    JOIN FETCH f.carta1
    JOIN FETCH f.carta2
    JOIN FETCH f.result
    WHERE f.result.id = :result
    """)
    List<Fusao> findByResult(@Param("result") Integer result);

}
