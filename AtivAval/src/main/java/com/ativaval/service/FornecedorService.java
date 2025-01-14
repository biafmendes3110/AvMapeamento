package com.ativaval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ativaval.entity.Fornecedor;
import com.ativaval.repository.FornecedorRepository;

@Service
public class FornecedorService {
	private final FornecedorRepository fornecedorRepository;

	@Autowired
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	public List<Fornecedor> buscaTodosFornecedor(){
		return fornecedorRepository.findAll();
	}
	public Fornecedor buscaFornecedorId(Long id) {
		Optional <Fornecedor> Fornecedor = fornecedorRepository.findById(id);
		return Fornecedor.orElse(null);
	}
	public Fornecedor salvaFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}
	public Fornecedor alterarFornecedor(Long id, Fornecedor alterarF) {
		Optional <Fornecedor> existeFornecedor = fornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			return fornecedorRepository.save(alterarF);
		}
		return null;

	}
	public boolean apagarFornecedor(Long id) {
		Optional <Fornecedor> existeFornecedor= fornecedorRepository.findById(id);
		if (existeFornecedor.isPresent()) {
			fornecedorRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

