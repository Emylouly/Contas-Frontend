package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifba.demo.frontend.dto.ContasDTO;
import br.edu.ifba.demo.frontend.service.ContasService;

@Controller
@RequestMapping("/contas")
public class ContasController {

    @Autowired
    private ContasService contasService;



}
