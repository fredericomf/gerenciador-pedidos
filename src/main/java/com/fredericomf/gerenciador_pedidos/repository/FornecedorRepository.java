package com.fredericomf.gerenciador_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fredericomf.gerenciador_pedidos.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

}