package com.dae.ep4.repository;

import com.dae.ep4.entity.Visita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {

    @Query("SELECT v FROM Visita v WHERE v.id = ?1")
    public List<Visita> findAll(Integer id);
}
