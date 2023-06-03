package com.saulodev.bergan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saulodev.bergan.domain.Funcionario;
import com.saulodev.bergan.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;

    @GetMapping(value = "{id}")
    public Funcionario buscarPorUm(@PathVariable Long id) {
        return service.buscarPorUm(id);
    }

}
