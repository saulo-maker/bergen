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

    @OneToOne(mappedBy="respAgendamento")
    private Agendamento agendamento;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Float getComissao() {
        return this.comissao;
    }

    public void setComissao(Float comissao) {
        this.comissao = comissao;
    }

    public Agendamento getAgendamento() {
        return this.agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

}
