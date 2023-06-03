package com.saulodev.bergan.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private Long id_agendamento;

    @Column(name = "data")
    private Date data = new Date();

    @Column(name = "hora")
    private Date hora;

    @Column(name = "status")
    private String status;

    @Column(name = "observacao")
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "respAgendamento")
    private Funcionario respAgendamento;

    @JsonIgnore
    @OneToMany(mappedBy = "agendamento")
    private List<Servico> servicos;


    public Long getId_agendamento() {
        return this.id_agendamento;
    }

    public void setId_agendamento(Long id_agendamento) {
        this.id_agendamento = id_agendamento;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return this.hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getRespAgendamento() {
        return this.respAgendamento;
    }

    public void setRespAgendamento(Funcionario respAgendamento) {
        this.respAgendamento = respAgendamento;
    }

    public List<Servico> getServicos() {
        return this.servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

}
