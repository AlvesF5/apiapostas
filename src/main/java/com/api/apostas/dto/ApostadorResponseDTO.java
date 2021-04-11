package com.api.apostas.dto;


import java.util.List;

import com.api.apostas.models.Aposta;
import com.api.apostas.models.Apostador;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ApostadorResponseDTO {
	private Long id;
	private String email;
	private List<Aposta> apostas;

	public ApostadorResponseDTO(Apostador apostador) {
		this.id=apostador.getId();
		this.email=apostador.getEmail();
		this.apostas=apostador.getApostas();
	}

}
