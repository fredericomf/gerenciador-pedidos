package com.fredericomf.gerenciador_pedidos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fredericomf.gerenciador_pedidos.model.Categoria;
import com.fredericomf.gerenciador_pedidos.model.Fornecedor;
import com.fredericomf.gerenciador_pedidos.model.Produto;
import com.fredericomf.gerenciador_pedidos.repository.CategoriaRepository;
import com.fredericomf.gerenciador_pedidos.repository.FornecedorRepository;
import com.fredericomf.gerenciador_pedidos.repository.PedidoRepository;
import com.fredericomf.gerenciador_pedidos.repository.ProdutoRepository;

@SpringBootApplication
public class GerenciadorPedidosApplication implements CommandLineRunner {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	FornecedorRepository fornecedorRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("1 - Retorne todos os produtos com o nome exato fornecido.");
		var produtos = produtoRepository.findByNome("Produto 1");
		produtos.forEach(System.out::println);
		System.out.println("");

		System.out.println("2 - Retorne todos os produtos associados a uma categoria específica.");
		Optional<Categoria> categoria = categoriaRepository.findById(2l);
		if (categoria.isPresent()) {
			produtoRepository.findByCategoria(categoria.get()).forEach(System.out::println);
		}
		System.out.println("");

		System.out.println("3 - Retorne produtos com preço maior que o valor fornecido.");
		produtoRepository.findByPrecoGreaterThan(new BigDecimal(5)).forEach(System.out::println);
		System.out.println("");

		System.out.println("4 - Retorne produtos com preço menor que o valor fornecido.");
		produtoRepository.findByPrecoLessThan(new BigDecimal(5)).forEach(System.out::println);
		System.out.println("");

		System.out.println("5 - Retorne produtos cujo nome contenha o termo especificado.");
		produtoRepository.findByNomeContainingIgnoreCase("produto").forEach(System.out::println);
		System.out.println("");

		System.out.println("6 - Retorne pedidos que ainda não possuem uma data de entrega.");
		pedidoRepository.findByDataIsNull().forEach(System.out::println);
		System.out.println("");

		System.out.println("7 - Retorne pedidos com data de entrega preenchida.");
		pedidoRepository.findByDataIsNotNull().forEach(System.out::println);
		System.out.println("");

		System.out.println("8 - Retorne produtos de uma categoria ordenados pelo preço de forma crescente.");
		if (categoria.isPresent()) {
			produtoRepository.findByCategoriaOrderByPrecoAsc(categoria.get()).forEach(System.out::println);
		}
		System.out.println("");

		System.out.println("9 - Retorne produtos de uma categoria ordenados pelo preço de forma decrescente.");
		if (categoria.isPresent()) {
			produtoRepository.findByCategoriaOrderByPrecoDesc(categoria.get()).forEach(System.out::println);
		}
		System.out.println("");

		System.out.println("10 - Retorne a contagem de produtos em uma categoria específica.");
		if (categoria.isPresent()) {
			System.out.println(produtoRepository.countByCategoria(categoria.get()));
		}
		System.out.println("");

		System.out.println("11 - Retorne a contagem de produtos cujo preço seja maior que o valor fornecido.");
		System.out.println(produtoRepository.countByPrecoGreaterThan(new BigDecimal(2.99)));
		System.out.println("");

		System.out.println(
				"12 - Retorne produtos com preço menor que o valor fornecido ou cujo nome contenha o termo especificado.");
		System.out.println(produtoRepository.countByPrecoLessThanOrNomeContainingIgnoreCase(new BigDecimal(3), "e"));
		System.out.println("");

		System.out.println("13 - Retorne pedidos feitos após uma data específica.");
		pedidoRepository.findByDataAfter(LocalDate.now().minusDays(30)).forEach(System.out::println);
		System.out.println("");

		System.out.println("14 - Retorne pedidos feitos antes de uma data específica.");
		pedidoRepository.findByDataBefore(LocalDate.now()).forEach(System.out::println);
		System.out.println("");

		System.out.println("15 - Retorne pedidos feitos em um intervalo de datas.");
		pedidoRepository.findByDataBetween(LocalDate.now().minusDays(30), LocalDate.now()).forEach(System.out::println);
		System.out.println("");

		System.out.println("16 - Retorne os três produtos mais caros.");
		produtoRepository.findTop3ByOrderByPrecoDesc().forEach(System.out::println);
		System.out.println("");

		System.out.println("17 - Retorne os cinco produtos mais baratos de uma categoria.");
		produtoRepository.findTop3ByOrderByPrecoAsc().forEach(System.out::println);
		System.out.println("");
	}

}
