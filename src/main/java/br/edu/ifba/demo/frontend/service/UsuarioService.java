package br.edu.ifba.demo.frontend.service;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifba.demo.frontend.dto.UsuarioDTO;
import reactor.core.publisher.Mono;

@Service
public class UsuarioService {
    private final String BASE_URL = "http://localhost:8081/usuario";
    private final RestTemplate restTemplate = new RestTemplate();
    private final WebClient webClient;

    public UsuarioService() {
        this.webClient = WebClient.builder().baseUrl(BASE_URL).build();
    }

    public List<UsuarioDTO> listAllUsuarios(){
        return webClient.get()
            .uri("/listalldados")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(UsuarioDTO.class)
            .collectList()
            .block();
    }

    public UsuarioDTO getById(Long idusuario){
        Mono<UsuarioDTO> monoObj = this.webClient
        .get() 
        .uri("/buscarporid/{id}", idusuario)
        .retrieve()
        .bodyToMono(UsuarioDTO.class);
        return monoObj.block();
        
    }
    

    public void criar(UsuarioDTO usuarioDTO){
        this.webClient.post()
                .uri("/criar")
                .bodyValue(usuarioDTO)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public boolean atualizar(UsuarioDTO usuarioDTO){
        UsuarioDTO salvar = this.webClient.post()
        .uri("/salvar")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(usuarioDTO)
        .retrieve()
        .bodyToMono(UsuarioDTO.class)
        .block();
        return salvar != null;
    }

    public void deletarUsuarios(Long id, RedirectAttributes redirectAttributes) {
    try {
        restTemplate.delete(BASE_URL + "/delete/{id}", id);
        redirectAttributes.addFlashAttribute("deleteUsuario", "Usuário excluído com sucesso!");
    } catch (Exception e) {
        redirectAttributes.addFlashAttribute("erroDelete", "Não é possível excluir o usuário, pois há contas vinculadas a ele.");
    }
}



}
