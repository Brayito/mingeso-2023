package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reporte_resumen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    private String rut;
    private String nombre;
    private Integer examenes_rendidos;

    private double promedio_puntaje;

    private double monto_pagar;
    private String tipo_pago;
    private Integer total_cuotas;
    private Integer cuotas_pactadas;
    private Integer cuotas_pagadas;

    private double monto_pagado;
    private Date ultimo_pago;
    private Integer monto_restante;
    private Integer cuotas_retraso;

}
