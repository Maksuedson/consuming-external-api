package com.cep.resttemplate.dto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cep.resttemplate.dto.CepResponseDTO;

@RestController
@RequestMapping("consulta-cep")
public class SearchCepController {

	@GetMapping("{cep}")
	public CepResponseDTO searchCep(@PathVariable("cep") String cep) {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<CepResponseDTO> resp = 
				restTemplate
				.getForEntity
				(String.format("https://viacep.com.br/ws/%s/json", cep), CepResponseDTO.class);

		return resp.getBody();

	}

}
