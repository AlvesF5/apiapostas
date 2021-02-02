package com.apostas.api.apostas.api.dto;

import com.apostas.api.apostas.api.model.ApostaSimplesMegasena;
import com.apostas.api.apostas.api.model.Apostador;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTORequestApostador {
    private String email;
    private List<ApostaSimplesMegasena> apostas;


    public Apostador build(){
        return new Apostador()
                .setEmail(this.email)
                .setListaapostas(this.apostas);
    }
}


