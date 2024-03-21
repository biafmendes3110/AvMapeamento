package com.ativaval.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ativaval.entity.ItemPedido;
import com.ativaval.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	private final ItemPedidoRepository itemPedidoRepository;

	@Autowired
	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository= itemPedidoRepository;
	}
	public List<ItemPedido> buscaTodosItemPedido(){
		return itemPedidoRepository.findAll();
	}
	public ItemPedido buscaItemPedidoId(Long id) {
		Optional <ItemPedido> ItemPedido = itemPedidoRepository.findById(id);
		return ItemPedido.orElse(null);
	}
	public ItemPedido salvaItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	public ItemPedido alterarItemPedido(Long id, ItemPedido alterarI) {
		Optional <ItemPedido> existeItemPedido = itemPedidoRepository.findById(id);
		if (existeItemPedido.isPresent()) {
			return itemPedidoRepository.save(alterarI);
		}
		return null;

	}
	public boolean apagarItemPedido(Long id) {
		Optional <ItemPedido> existeItemPedido= itemPedidoRepository.findById(id);
		if (existeItemPedido.isPresent()) {
			itemPedidoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}

