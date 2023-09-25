package com.example.demo.services;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public void guardarEstudiante(String rut, String apellidos, String nombres, Date fechaNacimiento, String tipoColegio, String nombreColegio, Integer anoEgreso){
        EstudianteEntity estudiante = new EstudianteEntity();
        estudiante.setRut(rut);
        estudiante.setApellidos(apellidos);
        estudiante.setNombres(nombres);
        estudiante.setFechanacimiento(fechaNacimiento);
        estudiante.setTipocolegio(tipoColegio);
        estudiante.setNombrecolegio(nombreColegio);
        estudiante.setAnoegreso(anoEgreso);
        estudianteRepository.save(estudiante);
    }

    public ArrayList<EstudianteEntity> obtenerEstudiantes(){
        return (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
    }
}
