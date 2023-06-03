package com.saulodev.bergan.controllers;

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

import com.saulodev.bergan.domain.Servico;
import com.saulodev.bergan.service.ServicoService;

@RestController
@RequestMapping(value = "/servico")
public class ServicoController {
    
    @Autowired
    private ServicoService service;

    @RequestMapping(value = "deletar/{id}", method = RequestMethod.DELETE)
    public void deletarServicoId(@PathVariable Long id) {
        service.deletarServicoId(id);
        System.out.println("Deletado com sucesso...");
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public ResponseEntity<Servico> cadastrarCliente(@RequestBody Servico servico) {
            service.cadastrar(servico);
        return ResponseEntity.ok(servico);
    }
    
    @PutMapping(value = "atualizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Servico> atualizarClienteId(@PathVariable Long id, @RequestBody Servico servico) {
            service.alterarServico(id, servico);
        return ResponseEntity.ok(servico);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorUm(@PathVariable Long id) {
        return service.buscarPorUm(id);
    }
    
    @GetMapping
	public List<Servico> listarTodos() {
		return service.todos();
	}

}