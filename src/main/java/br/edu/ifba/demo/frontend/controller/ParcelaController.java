package br.edu.ifba.demo.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifba.demo.frontend.dto.ParcelaDTO;
import br.edu.ifba.demo.frontend.service.ParcelaService;

@Controller
@RequestMapping("/parcela")
public class ParcelaController {

    @Autowired
    private ParcelaService parcelaService;


    @GetMapping("/listall/{idconta}")
    public ModelAndView listarParcelaPorConta(@PathVariable Long idcontas){
        List<ParcelaDTO> parcelas = parcelaService.listarParcelaPorConta(idcontas);
        parcelas.forEach(parcela -> System.out.println(parcela));

        ModelAndView model = new ModelAndView("parcela");
        model.addObject("listParcela", parcelas);
        return model;
    }
    
}
