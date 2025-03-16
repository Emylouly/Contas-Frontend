package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifba.demo.frontend.service.ContasService;
import br.edu.ifba.demo.frontend.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ContasService contasService; // Listar todos os livros

    
}