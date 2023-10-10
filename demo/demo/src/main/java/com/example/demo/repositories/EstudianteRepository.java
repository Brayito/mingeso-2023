package com.example.demo.repositories;

import com.example.demo.entities.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long>{


    @Query("select e from EstudianteEntity e where e.nombres = :nombres")
    EstudianteEntity findByNameCustomQuery(@Param("nombres") String nombres);

    @Query("select e.tipocolegio from EstudianteEntity e where e.rut = :rut")
    String findTipoColegio(@Param("rut") String rut);

    @Query("select e from EstudianteEntity e where e.rut = :rut")
    EstudianteEntity findByRut(@Param("rut")String rut);

}
