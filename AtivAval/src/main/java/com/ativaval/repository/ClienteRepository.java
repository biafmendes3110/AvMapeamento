package com.ativaval.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ativaval.entity.Cliente;

public interface ClienteRepository  extends JpaRepository <Cliente, Long>{

}
