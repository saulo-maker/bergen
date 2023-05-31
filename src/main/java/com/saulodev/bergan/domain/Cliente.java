package com.saulodev.bergan.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(name = "cliente") 
public class Cliente {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", unique = true, nullable = false)
    private Long id;

    @Column(name = "nome", length = 80, nullable = false)
    private String nome;

    @Column(name = "telefone", length = 20, nullable = false)
    private String telefone;

    @Column(name = "email", length = 80, nullable = false)
    private String email;

    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @OneToMany(mappedBy="cliente")
    List<Agendamento> agendamentos;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

}