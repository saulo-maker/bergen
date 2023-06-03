package com.saulodev.bergan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.saulodev.bergan.domain.Funcionario;
import com.saulodev.bergan.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;

    public Funcionario buscarPorUm(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Funcionario> todos() {
        return repository.findAll();
    }

    public Funcionario cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        return repository.save(funcionario);
    }
}
