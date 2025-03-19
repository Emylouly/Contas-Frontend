package br.edu.ifba.demo.frontend.service;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifba.demo.frontend.dto.ParcelaDTO;

@Service
public class ParcelaService {
    private final String BASE_URL = "http://localhost:8081/parcela";
    private final RestTemplate restTemplate = new RestTemplate();
    private final WebClient webClient;

    public ParcelaService() {
        this.webClient = WebClient.builder().baseUrl(BASE_URL).build();
    }

    public List<ParcelaDTO> listarParcelaPorConta(Long idcontas) {
        return webClient.get()
            .uri("/buscarporconta/{idconta}", idcontas)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToFlux(ParcelaDTO.class)
            .collectList()
            .block();
    }
    
}
