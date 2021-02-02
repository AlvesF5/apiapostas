package com.apostas.api.apostas.api.dto;

import com.apostas.api.apostas.api.model.ApostaSimplesMegasena;
import com.apostas.api.apostas.api.model.Apostador;
import com.apostas.api.apostas.api.repository.ApostadorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


public class DTOResponseApostador {
    private List<ApostaSimplesMegasena> listaapotas=null;
    private String email;

    public DTOResponseApostador(Apostador apostador){
        this.listaapotas = apostador.getListaapostas();
        this.email = apostador.getEmail();
    }

    ApostadorRepository apostadorRepository;

    public List<Apostador> buscarApostador(String email){
        return apostadorRepository.findByEmail(email);
    }


}

