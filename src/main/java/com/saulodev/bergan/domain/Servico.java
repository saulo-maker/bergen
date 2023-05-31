package com.saulodev.bergan.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico", unique = true, nullable = false)
    private long id;

    @Column(name = "nome", unique = false, nullable = false)
    private String nome;

    @Column(name = "descricao", unique = false, nullable = false)
    private String descricao;

    @Column(name = "precoCusto", unique = false, nullable = false)
    private Double precoCusto;

    @Column(name = "precoVenda", unique = false, nullable = false)
    private Double precoVenda;

    @ManyToOne
    private Agendamento agendamento;
}
