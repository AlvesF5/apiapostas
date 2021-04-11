package com.api.apostas.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.apostas.models.Aposta;
import com.api.apostas.models.Apostador;
import com.api.apostas.repository.ApostadorRepository;



@Service
public class ApostadorService {
	
	@Autowired
	private  ApostadorRepository apostadorRepository;
	

	public Apostador salvarApostador(Apostador apostador) {
		
		Aposta aposta = new Aposta();
		
		if(apostadorRepository.findByEmail(apostador.getEmail())==null) {
			
			aposta.setApostador(apostador);
			apostador.setApostas(List.of(aposta));
			return apostadorRepository.save(apostador);
			
		}else {
			Apostador apost = apostadorRepository.findByEmail(apostador.getEmail());
			
			if(apost.equals(aposta)) {
				Aposta novaAposta = new Aposta();
				novaAposta.setApostador(apost);
				apost.getApostas().add(novaAposta);
				
			}else {
				aposta.setApostador(apost);
				apost.getApostas().add(aposta);
			}
						
			return apostadorRepository.save(apost);
		}
	}
	
	
	public List<Aposta> buscarApostas(String email){
		
		List<Aposta> apostas = new ArrayList<Aposta>();
		apostas = apostadorRepository.findByEmail(email).getApostas();
		apostas.sort(Comparator.comparing(Aposta::getCriadaEm));
		
		return apostas;
	}
	
	

}
