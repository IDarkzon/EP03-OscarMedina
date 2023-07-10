package com.dae.ep4.controller;

import com.dae.ep4.entity.Usuario;
import com.dae.ep4.service.IUsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@AllArgsConstructor
@Controller
public class UsuarioController {

    @Autowired
    private final IUsuarioService usuarioService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "index";
    }


    @PostMapping("/")
    public String validarUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        try {
            Usuario userValidator = usuarioService.findById(usuario.getUsuario());

            if (userValidator.getUsuario().equals(usuario.getUsuario().trim())
                    && userValidator.getPassword().equals(usuario.getPassword().trim())) {
                return "redirect:/visitas";
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            model.addAttribute("user", true);
            return "index";
        }
    }
}
