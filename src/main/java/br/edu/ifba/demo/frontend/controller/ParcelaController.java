package br.edu.ifba.demo.frontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifba.demo.frontend.dto.ParcelaDTO;
import br.edu.ifba.demo.frontend.service.ParcelaService;

@Controller
@RequestMapping("/parcela")
public class ParcelaController {

    @Autowired
    private ParcelaService parcelaService;


    @GetMapping("/listall/{idconta}")
    public ModelAndView listarParcelaPorConta(@PathVariable Long idconta) {
        List<ParcelaDTO> parcelas = parcelaService.listarParcelaPorConta(idconta);
        parcelas.forEach(parcela -> System.out.println(parcela));

        ModelAndView model = new ModelAndView("parcela");
        model.addObject("listParcela", parcelas);
        return model;
    }

    @Controller
@RequestMapping("/parcela")
public class ParcelaFrontController {

    @Autowired
    private ParcelaService parcelaService;

    @GetMapping("/delete/{id}")
    public String deletarParcela(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            parcelaService.deletarParcela(id); // Chama o método do service
            redirectAttributes.addFlashAttribute("successMessage", "Parcela deletada com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao deletar parcela: " + e.getMessage());
        }
        return "redirect:/parcela/listall"; // Redireciona para a lista de parcelas
    }
}
    
}
