package com.example.demo.services;

import com.example.demo.entities.CuotasEntity;

import com.example.demo.entities.CuotasEntity;
import com.example.demo.entities.EstudianteEntity;
import com.example.demo.entities.ReporteEntity;
import com.example.demo.repositories.CuotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CuotasService {

    @Autowired
    CuotasRepository cuotasRepository;

    @Autowired
    EstudianteService estudianteService;

    public void guardarCuotas(String rut, Integer max_cuotas){
        CuotasEntity cuotas = new CuotasEntity();
        cuotas.setRut(rut);
        cuotas.setArancel(1500000.0);
        cuotas.setMax_cuotas(max_cuotas);
        cuotas.setCuotas_pagadas(0);
        if (max_cuotas == 1){
            cuotas.setMonto_cuota(cuotas.getArancel()/2);
            cuotas.setCuotas_por_pagar(max_cuotas-cuotas.getCuotas_pagadas());
        }else{
            cuotas.setMonto_cuota(cuotas.getArancel()/max_cuotas);
            cuotas.setCuotas_por_pagar(max_cuotas-cuotas.getCuotas_pagadas());
        }


        cuotasRepository.save(cuotas);
    }

    public void calculoCuotas(String rut){
        if (rut != null){
            EstudianteEntity estudianteActual = estudianteService.estudianteRepository.findByRut(rut);
            System.out.println("Verificando cuotas al estudiante mediante rut: " + rut);
            CuotasEntity cuotas = new CuotasEntity();
            if (estudianteActual.getTipocolegio().equals("Privado") ){
                
            } else if (estudianteActual.getTipocolegio().equals("Privado")) {
                
            }

        }else{
            System.out.println("rut = null");
        }
    }

    public void aceptarPagoCuota(String rut, Integer cuotasPagadas, Integer cuotasPorPagar){
        CuotasEntity cuotas = cuotasRepository.findByRut(rut);
        cuotas.setCuotas_pagadas(cuotasPagadas);
        cuotas.setCuotas_por_pagar(cuotasPorPagar);
        cuotasRepository.save(cuotas);
    }
    public CuotasEntity obtenerCuotasPorRut(String rut){
        CuotasEntity cuotas = cuotasRepository.findByRut(rut);
        return cuotas;
    }

    public ArrayList<CuotasEntity> obtenerCuotas(){
        return (ArrayList<CuotasEntity>) cuotasRepository.findAll();
    }
}
