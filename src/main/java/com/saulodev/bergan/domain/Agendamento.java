package com.saulodev.bergan.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamento")
public class Agendamento {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agendamento", unique = true, nullable = false)
    private Long id;

    @Column(name = "data")
    private Date data = new Date();

    @Column(name = "hora")
    private Date hora;

    @Column(name = "status")
    private String status;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Funcionario respAgendamento;

    @OneToMany
    private List<Servico> servicos;

}
