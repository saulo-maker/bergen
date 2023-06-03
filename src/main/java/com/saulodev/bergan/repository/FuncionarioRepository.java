package com.saulodev.bergan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saulodev.bergan.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
}
