package com.example.demo.repositories;

import com.example.demo.entities.CuotasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CuotasRepository extends JpaRepository<CuotasEntity, Long> {

    @Query("select e from CuotasEntity e where e.rut = :rut")
    CuotasEntity findByRut(@Param("rut")String rut);
}