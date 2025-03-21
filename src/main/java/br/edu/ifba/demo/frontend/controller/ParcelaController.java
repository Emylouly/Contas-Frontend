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


    @GetMapping("/delete/{id}")
    public String deletarParcela(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            Long idConta = parcelaService.deletarParcela(id);
            redirectAttributes.addFlashAttribute("successMessage", "Parcela deletada com sucesso!");
            return "redirect:/parcela/listall/" + idConta;
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Erro ao deletar parcela: " + e.getMessage());
            return "redirect:/parcela/listall";
        }
    }

    @GetMapping("/form")
    public ModelAndView formularioParcela() {
        return new ModelAndView("parcela_form");
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarParcela(@PathVariable Long id) {
        ParcelaDTO parcela = parcelaService.getById(id);
        ModelAndView model = new ModelAndView("parcela_form");
        model.addObject("parcela", parcela);
        model.addObject("modoEdicao", true);
        return model;
    }
}

    
