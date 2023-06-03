package com.saulodev.bergan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.saulodev.bergan.repository.ClienteRepository;

import com.saulodev.bergan.domain.Cliente;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;
	
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		repository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
    
	public Cliente alterarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {

		Cliente clienteUpdate = repository.findById(id).orElse(null);
		clienteUpdate.setId(cliente.getId());
		clienteUpdate.setNome(cliente.getNome());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefone(cliente.getTelefone());
		clienteUpdate.setUf(cliente.getUf());

		return repository.save(clienteUpdate);
	}

	public void deletarClienteId(Long id) {
		repository.deleteById(id);
	}

	public List<Cliente> todos() {
		return repository.findAll();
	}

	public Cliente buscarPorUm(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void deletarUm(Long id) {
		repository.deleteById(id);
	}
}