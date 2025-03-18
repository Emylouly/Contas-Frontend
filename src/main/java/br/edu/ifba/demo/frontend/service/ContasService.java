package br.edu.ifba.demo.frontend.service;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.demo.frontend.dto.ContasDTO;

@Service
public class ContasService {
    private final String BASE_URL = "http://localhost:8081/contas";
    private final RestTemplate restTemplate = new RestTemplate();
    private final WebClient webClient;

    public ContasService() {
        this.webClient = WebClient.builder().baseUrl(BASE_URL).build();
    }

    public List<ContasDTO> listAllContas(){
        return webClient.get()
            .uri("/listall")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(ContasDTO.class)
            .collectList()
            .block();
    }

    public List<ContasDTO> listarContasPorUsuario(Long idusuario) {
        return webClient.get()
            .uri("/buscarporidusuario/{idusuario}", idusuario)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(ContasDTO.class)
            .collectList()
            .block();
    }
    

    public void addContas(ContasDTO contasDTO) {
        this.webClient.post()
                .uri("/salvar")
                .bodyValue(contasDTO)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

    }

    public boolean salvarEatualizar(ContasDTO contasDTO) {
        ContasDTO salvar = this.webClient.post()
                .uri("/salvar")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(contasDTO)
                .retrieve()
                .bodyToMono(ContasDTO.class)
                .block();
        return salvar != null;
    }
    

    public void deletarContas(Long id) {
        this.webClient.delete()
                .uri("/delete/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
    
}