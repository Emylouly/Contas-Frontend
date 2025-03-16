package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifba.demo.frontend.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listall")
    public ModelAndView listarUsuarios() {
        ModelAndView model = new ModelAndView("usuario");
        model.addObject("listaUsuario", usuarioService.listAllUsuarios());
        return model;
    }

}
