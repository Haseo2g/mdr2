package com.fm.app.repository;

import com.fm.app.model.Drops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DropsRepository extends JpaRepository<Drops, Integer> {
    @Query("""
    SELECT d FROM Drops d
    JOIN FETCH d.carta
    JOIN FETCH d.duelista
    WHERE d.carta.id = :cartaId
    AND d.chance > 0
    Order by d.duelista.id
    """)
    List<Drops> findByCarta(@Param("cartaId") Integer cartaId);

    @Query("""
    SELECT d FROM Drops d
    JOIN FETCH d.carta
    JOIN FETCH d.duelista
    WHERE d.duelista.id = :duelistaId
    AND d.chance > 0
    Order by d.duelista.id
    """)
    List<Drops> findByDuelist(@Param("duelistaId") Integer duelistaId);
}
