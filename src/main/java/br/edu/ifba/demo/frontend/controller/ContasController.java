package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifba.demo.frontend.service.ContasService;

@Controller
@RequestMapping("/contas")
public class ContasController {

    @Autowired
    private ContasService contasService;

    @GetMapping("/listall")
    public ModelAndView listarContas(){
        ModelAndView model = new ModelAndView("conta");
        model.addObject("listaConta", contasService.listAllContas());
        return model;
    }

    @GetMapping("/listall/{idusuario}")
    public ModelAndView listarContasPorUsuario(@PathVariable Long idusuario) {
        ModelAndView model = new ModelAndView("conta");
        model.addObject("listaConta", contasService.listarContasPorUsuario(idusuario));
        return model;
    }


}
