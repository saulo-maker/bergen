package com.saulodev.bergan.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saulodev.bergan.domain.Funcionario;
import com.saulodev.bergan.service.FuncionarioService;


@RestController
@RequestMapping(value = "/funcionario")
@CrossOrigin(origins = "http://localhost:4200")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;

    @PutMapping(value = "atualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> atualizaFuncionario(@PathVariable Long id, @RequestBody Funcionario funcionario) {
            service.atualizaFuncionario(id, funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<Funcionario> name(@RequestBody Funcionario funcionario) {
        service.cadastrarFuncionario(funcionario);
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping(value = "/{id}")
    public Funcionario buscarPorUm(@PathVariable Long id) {
        return service.buscarPorUm(id);
    }

    @GetMapping()
    public List<Funcionario> todos() {
        return service.todos();
    }
}
