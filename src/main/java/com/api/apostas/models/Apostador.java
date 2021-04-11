package com.api.apostas.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="tb_apostador")
public class Apostador {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String email;
	@OneToMany(mappedBy = "apostador", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Aposta> apostas;
	
	
	public Apostador(String email, List<Aposta> apostas) {
		this.email=email;
		this.apostas=apostas;
	}

	
	
	public boolean equals(Aposta aposta) {
	   boolean existe;
	   if(this.apostas.iterator().next().getNumeroAposta()==aposta.getNumeroAposta()) {
		   existe = true;
	   }else {
		   existe = false;
	   }
		   
	   return existe; 
	   
	}

	
	
	
	

}
