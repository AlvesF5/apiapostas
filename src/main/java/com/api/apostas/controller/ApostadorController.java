package com.api.apostas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.apostas.models.Aposta;
import com.api.apostas.models.Apostador;
import com.api.apostas.repository.ApostadorRepository;

@RestController
@RequestMapping(value="/api-apostas")
public class ApostadorController {
	
	@Autowired
	ApostadorRepository apostadorRepository;
	
	
	
	@GetMapping("/apostas/{email}")
	public List<Aposta> listaApostas(@PathVariable("email") String email) {
		return apostadorRepository.findByEmail(email).getApostas();
	}
	
	
	
	@PostMapping("/apostas/nova")
	public Apostador novaAposta(@RequestBody Apostador apostador) {
    
		
		Aposta aposta = new Aposta();
		apostador.setApostas(List.of(aposta));
		
		aposta.setApostador(apostador);
			
		
	    if(apostadorRepository.findAll().contains(apostador)) {
	    	String emailApostador = apostador.getEmail();
	    	if(apostadorRepository.findByEmail(emailApostador).getApostas().contains(aposta)) {
	    		Aposta novaAposta = new Aposta();
	    		novaAposta.setApostador(apostador);
	    	   apostadorRepository.findByEmail(emailApostador).setApostas(List.of(novaAposta));
	    		
	    	}else {
	    		apostadorRepository.findByEmail(emailApostador).setApostas(List.of(aposta));
	    		
	    	}
	    }
			
		return apostadorRepository.save(apostador);
	    
	}

}
