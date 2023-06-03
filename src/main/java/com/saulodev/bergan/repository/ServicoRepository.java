package com.saulodev.bergan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saulodev.bergan.domain.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
