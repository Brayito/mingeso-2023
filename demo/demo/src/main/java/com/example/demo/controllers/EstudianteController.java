package com.example.demo.controllers;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping
public class EstudianteController {
    @Autowired
    EstudianteService estudianteService;

    @GetMapping("/lista-estudiantes")
    public String listaEstudiantes(Model model) {
        ArrayList<EstudianteEntity> estudiantes = estudianteService.obtenerEstudiantes();
        model.addAttribute("estudiantes", estudiantes);
        return "lista-estudiantes";
    }

    @GetMapping("/nuevo-estudiante")
    public String estudiante() {
        return "nuevo-estudiante";
    }

    @PostMapping("/nuevo-estudiante")
    public String nuevoEstudiante(
            @RequestParam("rut") String rut,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("nombres") String nombres,
            @RequestParam("fechaNacimiento") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaNacimiento,
            @RequestParam("tipoColegio") String tipoColegio,
            @RequestParam("nombreColegio") String nombreColegio,
            @RequestParam("anoEgreso") Integer anoEgreso) throws Exception {


        estudianteService.guardarEstudiante(rut, apellidos, nombres, fechaNacimiento, tipoColegio, nombreColegio, anoEgreso);
        if (tipoColegio.equals("Privado")) {
            return "redirect:/asignar-cuotas-privado";
        } else if (tipoColegio.equals("Subvencionado")) {
            return "redirect:/asignar-cuotas-privado";
        } else if (tipoColegio.equals("Municipal")) {
            return "redirect:/asignar-cuotas-municipal";
        }
        return "redirect:/nuevo-estudiante";
    }
}

