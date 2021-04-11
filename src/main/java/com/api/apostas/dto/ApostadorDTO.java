package com.api.apostas.dto;

import java.util.List;

import com.api.apostas.models.Aposta;
import com.api.apostas.models.Apostador;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApostadorDTO {
	
	private String email;
	private List<Aposta> apostas;
	
	
	public Apostador tranformarParaObjeto() {
		return new Apostador(email,apostas);
	}

}
