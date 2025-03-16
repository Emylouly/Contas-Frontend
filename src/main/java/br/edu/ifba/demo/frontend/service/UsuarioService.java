package br.edu.ifba.demo.frontend.service;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

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
            .uri("/listall")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(UsuarioDTO.class)
            .collectList()
            .block(); // Bloqueia até que os dados sejam retornados
    }
    

    public void addUsuario(UsuarioDTO usuarioDTO){
        this.webClient.post()
                .uri("/salvar") // Correto para gêneros
                .bodyValue(usuarioDTO)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public boolean salvarEatualizar(UsuarioDTO usuarioDTO){
        UsuarioDTO salvar = this.webClient.post()
        .uri("/salvar")
        .contentType(MediaType.APPLICATION_JSON)
        .bodyValue(usuarioDTO)
        .retrieve()
        .bodyToMono(UsuarioDTO.class)
        .block();
        return salvar != null;
    }

    public boolean deletarUsuarios(int id){
        Mono<UsuarioDTO> usuarioList = this.webClient
            .method(HttpMethod.DELETE)  
            .uri("/delete/{id}", id)
            .retrieve()
            .bodyToMono(UsuarioDTO.class);
        
        UsuarioDTO usu = usuarioList.block();
        if (usu!=null) {
            return true;
        }
        return false;

    }

    


}
