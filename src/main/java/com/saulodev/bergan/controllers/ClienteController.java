package com.saulodev.bergan.controllers;

import com.saulodev.bergan.domain.Cliente;
import com.saulodev.bergan.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
    public void deletarClienteId(@PathVariable Long id) {
        service.deletarClienteId(id);
        System.out.println("Deletado com sucesso...");
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
            service.cadastrar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping(value = "atualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> atualizarClienteId(@PathVariable Long id, @RequestBody Cliente cliente) {
            service.alterarCliente(id, cliente);
        return ResponseEntity.ok(cliente);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorUm(@PathVariable Long id) {
            Cliente entity = service.buscarPorUm(id);
        return ResponseEntity.ok(entity);
    }
    
    @GetMapping
	public List<Cliente> listarTodos() {
		return service.todos();
	}

}
