package com.ativaval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ativaval.entity.Produto;

public interface ProdutoRepository  extends JpaRepository <Produto, Long>{

}
