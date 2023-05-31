package com.saulodev.bergan.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity(name = "funcionario")
public class Funcionario {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario", unique = true, nullable = false)
    private Long id;

    @Column(name = "login", unique = false, nullable = false)
    private String login;

    @Column(name = "senha", unique = true, nullable = false)
    private String senha;
    
    @Column(name = "email", unique = false, nullable = false)
    private String email;

    @Column(name = "fone", unique = false, nullable = false)
    private String fone;

    @Column(name = "comissao", unique = false, nullable = false)
    private Float comissao;

    @OneToOne
    private Agendamento agendamento;
}
