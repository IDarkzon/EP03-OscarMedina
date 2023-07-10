package com.dae.ep4.controller;

import com.dae.ep4.entity.Visita;
import com.dae.ep4.service.IVisitaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/visitas")
@AllArgsConstructor
@Controller
public class VisitaController {

    @Autowired
    private final IVisitaService visitaService;

    @GetMapping("")
    public String Listar(Model model, @Param("id") Integer id){
        List<Visita> visitas = visitaService.Listar(id);

        model.addAttribute("id", id);
        model.addAttribute("visitas", visitas);

        return "visitas/index";
    }

    @PostMapping("")
    public String Guardar(@ModelAttribute("visita") Visita visita) {
        try {
            visitaService.save(visita);
        } catch (Exception e) {}

        return "redirect:/visitas";
    }

    @PutMapping("")
    public String Actualizar(@ModelAttribute("visita") Visita visita) {
        visitaService.save(visita);

        return "redirect:/visitas";
    }

    @GetMapping("/delete/{id}")
    public String Eliminar(@PathVariable Integer id, Model model){
        visitaService.delete(id);

        return "redirect:/visitas";
    }
}
