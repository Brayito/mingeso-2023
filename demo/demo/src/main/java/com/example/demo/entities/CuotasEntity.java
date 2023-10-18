package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "cuotas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CuotasEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    private String rut;
    private Double arancel;
    private Integer max_cuotas;
    private Integer cuotas_pagadas;
    private Integer cuotas_por_pagar;
    private Double monto_cuota;

}