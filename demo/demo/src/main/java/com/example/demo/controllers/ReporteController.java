package com.example.demo.controllers;

import com.example.demo.entities.ReporteEntity;
import com.example.demo.services.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping
public class ReporteController {
    @Autowired
    ReporteService reporteService;

    @GetMapping("/reporte-pagos")
    public String listarReportes(Model model){
        reporteService.reportePlanilla();
        ArrayList<ReporteEntity> reportes=reporteService.obtenerReportes();
        model.addAttribute("reportes", reportes);
        return "reporte-pagos";
    }
}
