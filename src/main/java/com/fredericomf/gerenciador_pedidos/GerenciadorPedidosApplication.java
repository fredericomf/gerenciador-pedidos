package com.fredericomf.gerenciador_pedidos;

import java.math.BigDecimal;

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

		Fornecedor f = new Fornecedor();
		f.setNome("Frederico");
		f = fornecedorRepository.save(f);

		Categoria c = new Categoria();
		c.setNome("Teste");

		Produto p = new Produto();

		p.setNome("Teste");
		p.setPreco(new BigDecimal(2.33));
		p.setFornecedor(f);
		p.setCategoria(c);

		produtoRepository.save(p);
	}

}
