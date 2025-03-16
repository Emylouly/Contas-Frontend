package br.edu.ifba.demo.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifba.demo.frontend.dto.EnderecoDTO;
import br.edu.ifba.demo.frontend.dto.UsuarioDTO;
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

    @GetMapping("/view/{id}")
    public ModelAndView visualizarUsuario(@PathVariable("id") Long id) {
        UsuarioDTO usuario = usuarioService.getById(id);
            if (usuario.getEndereco() == null) {
            usuario.setEndereco(new EnderecoDTO());
        }

        ModelAndView model = new ModelAndView("usuario/form");
        model.addObject("usuario", usuario);
        model.addObject("view", true); // Indica que está no modo de visualização
        return model;
    }

    @GetMapping("/delete/{id}")
    public String deletarUsuario(@PathVariable Long id, RedirectAttributes redirectAttributes){
        usuarioService.deletarUsuarios(id);
        redirectAttributes.addFlashAttribute("deleteUsuario", "Usuário excluído com sucesso!");
        return "redirect:/usuario/listall";
    }

}
