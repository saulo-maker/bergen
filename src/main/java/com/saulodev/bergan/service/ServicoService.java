package com.saulodev.bergan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.saulodev.bergan.domain.Servico;
import com.saulodev.bergan.repository.ServicoRepository;

@Service
public class ServicoService {
    
    @Autowired
    private ServicoRepository repository;

    public Servico alterarServico(@PathVariable Long id, @RequestBody Servico servico) {

		Servico servicoUpdate = repository.findById(id).orElse(null);
		servicoUpdate.setId(servico.getId());
		servicoUpdate.setNome(servico.getNome());
		servicoUpdate.setDescricao(servico.getDescricao());
		servicoUpdate.setPrecoCusto(servico.getPrecoCusto());
		servicoUpdate.setPrecoVenda(servico.getPrecoVenda());
        servicoUpdate.setAgendamento(servico.getAgendamento());

		return repository.save(servicoUpdate);
	}

    public void deletarServicoId(@PathVariable Long id) {
        repository.deleteById(id);
    }

    public Servico cadastrar(@RequestBody Servico servico) {
        return repository.save(servico);
    }

    public ResponseEntity<Servico> buscarPorUm(@PathVariable Long id) {
        var entity = repository.findById(id).orElse(null);
        return ResponseEntity.ok(entity);
    }
    
    public List <Servico> todos() {
        return repository.findAll();
    }

}
