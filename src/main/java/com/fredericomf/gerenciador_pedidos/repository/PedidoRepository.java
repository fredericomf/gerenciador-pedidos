package com.fredericomf.gerenciador_pedidos.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fredericomf.gerenciador_pedidos.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // 6 - Retorne pedidos que ainda não possuem uma data de entrega.
    public List<Pedido> findByDataIsNull();

    // 7 - Retorne pedidos com data de entrega preenchida.
    public List<Pedido> findByDataIsNotNull();

    // 13 - Retorne pedidos feitos após uma data específica.
    public List<Pedido> findByDataAfter(LocalDate minusDays);

    // 14 - Retorne pedidos feitos antes de uma data específica.
    public List<Pedido> findByDataBefore(LocalDate now);

    // 15 - Retorne pedidos feitos em um intervalo de datas.
    public List<Pedido> findByDataBetween(LocalDate minusDays, LocalDate now);

}
