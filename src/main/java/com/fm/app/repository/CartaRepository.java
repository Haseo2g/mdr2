package com.fm.app.repository;

import com.fm.app.model.Carta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartaRepository extends JpaRepository<Carta, Integer> {
    @Query("SELECT c FROM Carta c WHERE " +
            "(:nome IS NULL OR LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%'))) AND " +
            "(:atk IS NULL OR c.atk >= :atk) AND " +
            "(:def IS NULL OR c.def >= :def) AND " +
            "(:type IS NULL OR c.type = :type)")
    List<Carta> findByFilters(@Param("nome") String nome,
                              @Param("atk") Integer atk,
                              @Param("def") Integer def,
                              @Param("type") String type);

}
