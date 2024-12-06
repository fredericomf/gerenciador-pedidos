package com.fredericomf.gerenciador_pedidos.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fredericomf.gerenciador_pedidos.model.Categoria;
import com.fredericomf.gerenciador_pedidos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // 1 - Retorne todos os produtos com o nome exato fornecido.
    List<Produto> findByNome(String nome);

    // 2 - Retorne todos os produtos associados a uma categoria específica.
    List<Produto> findByCategoria(Categoria categoria);

    // 3 - Retorne produtos com preço maior que o valor fornecido.
    List<Produto> findByPrecoGreaterThan(BigDecimal preco);

    // 4 - Retorne produtos com preço menor que o valor fornecido.
    List<Produto> findByPrecoLessThan(BigDecimal preco);

    // 5 - Retorne produtos cujo nome contenha o termo especificado.
    List<Produto> findByNomeContainingIgnoreCase(String nome);

    // 8 - Retorne produtos de uma categoria ordenados pelo preço de forma
    // crescente.
    List<Produto> findByCategoriaOrderByPrecoAsc(Categoria categoria);

    // 9 - Retorne produtos de uma categoria ordenados pelo preço de forma
    // decrescente.
    List<Produto> findByCategoriaOrderByPrecoDesc(Categoria categoria);

    // 10 - Retorne a contagem de produtos em uma categoria específica.
    Integer countByCategoria(Categoria categoria);

    // 11 - Retorne a contagem de produtos cujo preço seja maior que o valor
    // fornecido.
    Integer countByPrecoGreaterThan(BigDecimal bigDecimal);

    // 12 - Retorne produtos com preço menor que o valor fornecido ou cujo nome
    // contenha o termo especificado.
    Integer countByPrecoLessThanOrNomeContainingIgnoreCase(BigDecimal bigDecimal, String string);

    // 16 - Retorne os três produtos mais caros.
    List<Produto> findTop3ByOrderByPrecoDesc();

    // 17 - Retorne os cinco produtos mais baratos de uma categoria.
    List<Produto> findTop3ByOrderByPrecoAsc();
}
