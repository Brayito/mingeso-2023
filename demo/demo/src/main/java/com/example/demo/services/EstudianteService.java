package com.example.demo.services;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;

@Service
public class EstudianteService {
    @Autowired
    EstudianteRepository estudianteRepository;

    public void guardarEstudiante(String rut, String apellidos, String nombres, Date fechaNacimiento, String tipoColegio, String nombreColegio, Integer anoEgreso) throws Exception{
        EstudianteEntity estudianteExistente = estudianteRepository.findByRut(rut);
        if (estudianteExistente != null){
            JOptionPane.showMessageDialog(null, "El usuario con rut " + rut +"ya se encuentra registrado.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }else{
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

    }

    public EstudianteEntity obtenerEstudiantePorRut(String rut){
        EstudianteEntity estudiante = estudianteRepository.findByRut(rut);
        return estudiante;
    }


    public ArrayList<EstudianteEntity> obtenerEstudiantes(){
        return (ArrayList<EstudianteEntity>) estudianteRepository.findAll();
    }
}
