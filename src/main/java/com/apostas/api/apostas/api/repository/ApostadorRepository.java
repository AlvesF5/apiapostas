package com.apostas.api.apostas.api.repository;

import com.apostas.api.apostas.api.dto.DTORequestApostador;
import com.apostas.api.apostas.api.dto.DTOResponseApostador;
import com.apostas.api.apostas.api.model.Apostador;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApostadorRepository extends JpaRepository<Apostador, Long> {
    List<Apostador> findByEmail(String email);

}
