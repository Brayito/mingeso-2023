package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "estudiantes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long Id;
    private String rut;
    private String apellidos;
    private String nombres;
    private Date fechanacimiento;
    private String tipocolegio;
    private String nombrecolegio;
    private Integer anoegreso;

}
