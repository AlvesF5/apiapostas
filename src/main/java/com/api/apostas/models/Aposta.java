package com.api.apostas.models;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_aposta")
public class Aposta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private int aposta = gerarAposta().nextInt();
	@ManyToOne
	private Apostador apostador;
	
	
	
   public void setId(long id) {
		this.id = id;
	}


    public int getAposta() {
		return aposta;
	}


	public long getId() {
		return id;
	}
	

	public Apostador getApostador() {
		return apostador;
	}



	public void setApostador(Apostador apostador) {
		this.apostador = apostador;
	}


	public Random gerarAposta() {
	   Random numerosAposta = new Random();	   
	   return numerosAposta;
   }

}
