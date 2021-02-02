package com.apostas.api.apostas.api.controller;

import com.apostas.api.apostas.api.dto.DTORequestApostador;
import com.apostas.api.apostas.api.dto.DTOResponseApostador;
import com.apostas.api.apostas.api.model.ApostaSimplesMegasena;
import com.apostas.api.apostas.api.model.Apostador;
import com.apostas.api.apostas.api.repository.ApostadorRepository;
import org.jetbrains.annotations.ApiStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

public class ApostadorControler {

    Apostador apostador;

    @GetMapping(path = "/api/apostas/consultaapostador/{email}")
    @ApiStatus.OverrideOnly
    @ResponseStatus(HttpStatus.OK)
    public List<Apostador> consultarAposta(@PathVariable String email,@RequestParam int pagina, @RequestParam int qtd,
       @RequestParam String ordem) {
        Pageable pageable = (Pageable) PageRequest.of(pagina, qtd, Sort.Direction.ASC, ordem);
        return new DTOResponseApostador(apostador).buscarApostador(email);
    }

    @PostMapping(path = "/api/apostas/novaaposta")
    @ResponseStatus(HttpStatus.CREATED)
    public DTORequestApostador novaAposta(DTORequestApostador apostadorDTO){
        Apostador apostador = new Apostador();
        return   apostador.criarAposta(apostadorDTO);

    }

}
