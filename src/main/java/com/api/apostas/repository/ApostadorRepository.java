package com.api.apostas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.apostas.models.Apostador;

@Repository
public interface ApostadorRepository extends JpaRepository<Apostador, Long> {
	Apostador findByEmail(String email);
}
