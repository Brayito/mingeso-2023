package com.example.demo.controllers;

import com.example.demo.entities.EstudianteEntity;
import com.example.demo.services.EstudianteService;
import com.example.demo.entities.CuotasEntity;
import com.example.demo.services.CuotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
@Controller
@RequestMapping
public class CuotasController {
    @Autowired
    CuotasService cuotasService;
    @Autowired
    EstudianteService estudianteService;

    @GetMapping("/asignar-cuotas")
    public String cuotas(){
        return "asignar-cuotas";
    }

    @GetMapping("/asignar-cuotas-municipal")
    public String cuotasMuni(){
        return "asignar-cuotas-municipal";
    }
    @GetMapping("/asignar-cuotas-subvencionado")
    public String cuotasSubv(){
        return "asignar-cuotas-subvencionado";
    }
    @GetMapping("/asignar-cuotas-privado")
    public String cuotasPriv(){
        return "asignar-cuotas-privado";
    }


    @GetMapping("/lista-cuotas")
    public String listaCuotas(Model model) {
        ArrayList<CuotasEntity>cuotas=cuotasService.obtenerCuotas();
        model.addAttribute("cuotas", cuotas);
        return "lista-cuotas";
    }

    @PostMapping("/asignar-cuotas-privado")
    public String nuevaCuotaP(
            @RequestParam("rut") String rut,
            @RequestParam("max_cuotas") Integer max_cuotas) {


        cuotasService.guardarCuotas(rut,max_cuotas);
        return "redirect:/lista-estudiantes";
    }
    @PostMapping("/asignar-cuotas-municipal")
    public String nuevaCuotaN(
            @RequestParam("rut") String rut,
            @RequestParam("max_cuotas") Integer max_cuotas) {


        cuotasService.guardarCuotas(rut,max_cuotas);
        return "redirect:/lista-estudiantes";
    }

    @PostMapping("/asignar-cuotas-subvencionado")
    public String nuevaCuotaS(
            @RequestParam("rut") String rut,
            @RequestParam("max_cuotas") Integer max_cuotas) {


        cuotasService.guardarCuotas(rut,max_cuotas);
        return "redirect:/lista-estudiantes";
    }
}
