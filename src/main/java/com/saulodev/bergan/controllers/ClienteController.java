package com.saulodev.bergan.controllers;

import com.saulodev.bergan.domain.Cliente;
import com.saulodev.bergan.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService service;
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> procurarCliente(@PathVariable Long id) {
        Cliente entity = service.findById(id);
        return ResponseEntity.ok(entity);
    }
    
    @GetMapping
	public List<Cliente> listar() {
		return service.listar();
	}

}
