package br.edu.ifba.demo.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifba.demo.frontend.dto.ContasDTO;
import br.edu.ifba.demo.frontend.service.ContasService;

@Controller
@RequestMapping("/contas")
public class ContasController {

    @Autowired
    private ContasService contasService;

    @GetMapping("/listall/{idusuario}")
    public ModelAndView listarContasPorUsuario(@PathVariable Long idusuario) {
        List<ContasDTO> contas = contasService.listarContasPorUsuario(idusuario);
        contas.forEach(conta -> System.out.println(conta));
        
        ModelAndView model = new ModelAndView("conta");
        model.addObject("listaConta", contas);
        return model;
    }

    @GetMapping("/delete/{id}/{idusuario}")
    public String deletarConta(@PathVariable Long id, @PathVariable Long idusuario, RedirectAttributes redirectAttributes) {
        contasService.deletarContas(id, redirectAttributes);
        return "redirect:/contas/listall/" + idusuario;
    }

}
