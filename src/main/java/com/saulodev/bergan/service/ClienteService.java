package com.saulodev.bergan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saulodev.bergan.repository.ClienteRepository;
import com.saulodev.bergan.domain.Cliente;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;
    
	public List<Cliente> listar() {
		return repository.findAll();
	}

	public Cliente findById(Long id) {
		return repository.findById(id).orElse(null);
	}

}
