package com.api.apostas.models;

import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="tb_aposta")
public class Aposta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private int numeroAposta = gerarAposta();
	@ManyToOne
	private Apostador apostador;
	
	@Column
	private LocalDateTime criadaEm = LocalDateTime.now();
	

	public int gerarAposta() {
	   int numeros=0;
	   
	   Random numerosAposta = new Random();	   
	   
	   for(int i = 0; i < 6; i++) {
		 numeros+=numerosAposta.nextInt(10000000);
	   }
	   return numeros;
   }

	

}
