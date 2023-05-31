package com.saulodev.bergan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saulodev.bergan.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}