package com.apostas.api.apostas.api.model;

import com.apostas.api.apostas.api.dto.DTORequestApostador;
import com.apostas.api.apostas.api.repository.ApostadorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import javax.persistence.*;
import java.util.List;

@Data
@Accessors (chain = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "apostadores")
public class Apostador  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="email", nullable = false, unique = true)
    private String email;


    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private  List<ApostaSimplesMegasena> listaapostas;


    public Apostador(String email, List<ApostaSimplesMegasena> apostas) {
    }



    @Autowired
    ApostadorRepository apostadorRepository;


   public DTORequestApostador criarAposta(@RequestBody DTORequestApostador apostador){
       String emailApostador = apostador.build().getEmail();

       //Busca o e-mail do apostador no banco de dados
       List<Apostador> listaemails = apostadorRepository.findByEmail(emailApostador);

       //Query para buscar a aposta gerada para o apostador no banco de dados
       EntityManager session2 = null;
       javax.management.Query query = (javax.management.Query) session2.createQuery("from apostador " +
       "numeroaposta " + "where email = :email ");
       ((javax.persistence.Query) query).setParameter("email", apostador.build().getEmail());

       List listapostas = ((javax.persistence.Query) query).getResultList();

       if(listaemails.contains(listaemails.listIterator().next()) && listapostas.size()>0)
       {
           ApostaSimplesMegasena novaaposta = new ApostaSimplesMegasena();
           apostador.build().setListaapostas((List<ApostaSimplesMegasena>) novaaposta);

       } else {
           if(listaemails.contains(emailApostador) && listapostas.size()==0){
               apostador.build().setListaapostas(apostador.getApostas());
           }
       }
       this.apostadorRepository.save(apostador.build());
       return apostador;

   }

}
