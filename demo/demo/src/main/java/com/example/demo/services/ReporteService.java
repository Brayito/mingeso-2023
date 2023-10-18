package com.example.demo.services;

import com.example.demo.entities.CuotasEntity;
import com.example.demo.entities.EstudianteEntity;
import com.example.demo.entities.ReporteEntity;
import com.example.demo.repositories.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ReporteService {
    @Autowired
    ReporteRepository reporteRepository;

    @Autowired
    EstudianteService estudianteService;

    @Autowired
    CuotasService cuotasService;


    public ArrayList<ReporteEntity> obtenerReportes(){
        return (ArrayList<ReporteEntity>) reporteRepository.findAll();
    }

    public void reportePlanilla(){
        reporteRepository.deleteAll();
        ArrayList<EstudianteEntity> listaEstudiantes = estudianteService.obtenerEstudiantes();
        if (listaEstudiantes != null){
            for (int i = 0; i<listaEstudiantes.size(); i++){
                calculoPlanilla(listaEstudiantes.get(i).getRut());
            }
        }

    }

    public void calculoPlanilla(String rut){
        if (rut != null){

            EstudianteEntity estudianteActual = estudianteService.estudianteRepository.findByRut(rut);
            CuotasEntity cuotasActual = cuotasService.cuotasRepository.findByRut(rut);
            if (estudianteActual != null && cuotasActual != null) {
                System.out.println("Entrando al estudiante mediante rut: " + rut);
                ReporteEntity estudianteReporte = new ReporteEntity();
                estudianteReporte.setRut(estudianteActual.getRut());
                estudianteReporte.setNombre(estudianteActual.getNombres() + " " + estudianteActual.getApellidos());
                if (cuotasActual.getMax_cuotas() == 1) {
                    estudianteReporte.setTipo_pago("Contado");
                } else {
                    estudianteReporte.setTipo_pago("Cuotas");
                }
                estudianteReporte.setMonto_pagar(cuotasActual.getArancel() - cuotasActual.getArancel() * calcularDescuentoArancel(estudianteActual.getTipocolegio(), estudianteActual.getAnoegreso(),estudianteReporte.getTipo_pago()));
                System.out.println("Estudiante o cuotas no encontrados para el rut: " + rut +" gracias a descuento: " + calcularDescuentoArancel(estudianteActual.getTipocolegio(), estudianteActual.getAnoegreso(), estudianteReporte.getTipo_pago()));
                estudianteReporte.setCuotas_retraso(0);
                estudianteReporte.setCuotas_pagadas(cuotasActual.getCuotas_pagadas());
                estudianteReporte.setCuotas_pactadas(cuotasActual.getMax_cuotas());
                estudianteReporte.setExamenes_rendidos(0);

                estudianteReporte.setMonto_pagado(cuotasActual.getCuotas_pagadas() * cuotasActual.getMonto_cuota());
                estudianteReporte.setMonto_restante(estudianteReporte.getMonto_pagar() - (estudianteReporte.getMonto_pagado()));
                estudianteReporte.setUltimo_pago(new Date());
                reporteRepository.save(estudianteReporte);
            }else{
                System.out.println("Estudiante o cuotas no encontrados para el rut: " + rut);
            }
        }else{
            System.out.println("rut = null");
        }

    }
    /*
    public double descuentoTipoColegio(String tipoColegio){
        switch (tipoColegio) {
            case "Municipal":
                return (0.2);
            case "Subvencionado":
                return (0.1);
            case "Privado":
                return (0.0);
            default:
                return 0.0;
        }
    }

    public double descuentoAnoEgreso(Integer anoEgreso){
        if (anoEgreso < 1){
            return (0.15);
        } else if (anoEgreso >= 1 && anoEgreso <= 2) {
            return (0.08);
        } else if (anoEgreso > 3 && anoEgreso <= 4) {
            return (0.04);
        }else return (0.0);
    }
    */
    public double calcularDescuentoArancel(String TipoColegio, Integer anoEgreso, String TipoPago) {
        double descuentos = 0.0;
        switch (TipoPago) {
            case "Contado":
                System.out.println("Probando caso contado");
                descuentos = 0.5;
                return descuentos;
            case "Cuotas":
                System.out.println("Probando caso cuotas");
                switch (TipoColegio) {
                    case "Municipal":
                        descuentos = 0.2;
                        break;
                    case "Subvencionado":
                        descuentos = 0.1;
                        break;
                    case "Privado":
                        descuentos = 0.0;
                        break;
                }
                System.out.println("Probando if ano egreso");
                if (anoEgreso < 1) {
                    descuentos = descuentos + 0.15;
                } else if (anoEgreso >= 1 && anoEgreso <= 2) {
                    descuentos = descuentos + 0.08;
                } else if (anoEgreso > 3 && anoEgreso <= 4) {
                    descuentos = descuentos + 0.04;
                }
                break;
        }
        return descuentos;
    }
}
