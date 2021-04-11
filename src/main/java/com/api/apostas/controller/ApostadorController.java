package com.api.apostas.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apostas.dto.ApostadorDTO;
import com.api.apostas.dto.ApostadorResponseDTO;
import com.api.apostas.models.Aposta;
import com.api.apostas.models.Apostador;

import com.api.apostas.service.ApostadorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/apostas")
@Api(value="API APOSTAS")
@CrossOrigin(origins="*")
public class ApostadorController {
	
	@Autowired
	private  ApostadorService apostadorService;
	
	
	@GetMapping("/{email}")
	@ApiOperation(value="Lista as apostas do apostador através do seu e-mail")
	public List<Aposta> listaApostas(@PathVariable("email") String email) {	
		return apostadorService.buscarApostas(email);	
	}
		
	@PostMapping
	@ApiOperation(value="Cria uma aposta para o apostador através do seu e-mail")
	public ApostadorResponseDTO novaAposta(@RequestBody ApostadorDTO apostadorDTO) {			
	    return 	new ApostadorResponseDTO(apostadorService.salvarApostador(apostadorDTO.tranformarParaObjeto()));	
	}

}
