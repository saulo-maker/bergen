package com.saulodev.bergan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.saulodev.bergan.repository.ClienteRepository;

import jakarta.websocket.server.PathParam;

import com.saulodev.bergan.domain.Cliente;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;
    
	public List<Cliente> todos() {
		return repository.findAll();
	}

	public Cliente buscarPorUm(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void deletarUm(Long id) {
		repository.deleteById(id);
	}

	public Cliente alterarCliente(@PathVariable Long id, Cliente cliente) {

		Cliente clienteUpdate = repository.findById(null).orElse(null);

		clienteUpdate.setNome(cliente.getNome());
		clienteUpdate.setEmail(cliente.getEmail());
		clienteUpdate.setTelefone(cliente.getTelefone());
		clienteUpdate.setUf(cliente.getUf());

		return repository.save(clienteUpdate);
	}
}
