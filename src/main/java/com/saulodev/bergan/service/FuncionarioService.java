package com.saulodev.bergan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.saulodev.bergan.domain.Funcionario;
import com.saulodev.bergan.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario alterarFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {

		Funcionario funcionarioUpdate = repository.findById(id).orElse(null);
		funcionarioUpdate.setId(funcionario.getId());
		funcionarioUpdate.setLogin(funcionario.getLogin());
		funcionarioUpdate.setSenha(funcionario.getSenha());
		funcionarioUpdate.setFone(funcionario.getFone());
		funcionarioUpdate.setEmail(funcionario.getEmail());
        funcionarioUpdate.setComissao(funcionario.getComissao());

		return repository.save(funcionarioUpdate);
	}

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
