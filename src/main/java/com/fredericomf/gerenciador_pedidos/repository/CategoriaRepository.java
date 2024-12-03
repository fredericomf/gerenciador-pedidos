package com.fredericomf.gerenciador_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fredericomf.gerenciador_pedidos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
