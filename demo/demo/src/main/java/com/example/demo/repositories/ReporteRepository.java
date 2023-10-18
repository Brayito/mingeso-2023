package com.example.demo.repositories;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.entities.ReporteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepository extends JpaRepository<ReporteEntity, Long> {

    @Query("select e from ReporteEntity e where e.rut = :rut")
    ReporteEntity findByRut(@Param("rut")String rut);
}
