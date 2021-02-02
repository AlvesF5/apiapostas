package com.apostas.api.apostas.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Random;

@Data
@NoArgsConstructor
@Entity
@Table(name = "apostasmegasena")
public class ApostaSimplesMegasena implements Aposta{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aposta", nullable = false)
    private Integer numerosaposta = gerarNumeros();

    @Column(name = "criadaEm", nullable = false)
    private LocalDateTime criadaEm = LocalDateTime.now();

    @Override
    public Integer gerarNumeros() {
        Random gerador = new Random(6);
        return gerador.nextInt(1-60);
    }


}


