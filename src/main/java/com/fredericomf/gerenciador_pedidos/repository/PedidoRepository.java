package com.fredericomf.gerenciador_pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fredericomf.gerenciador_pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
