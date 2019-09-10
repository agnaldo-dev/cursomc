package com.agnaldo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agnaldo.cursomc.domain.Categoria;
import com.agnaldo.cursomc.domain.Cidade;
import com.agnaldo.cursomc.domain.Cliente;
import com.agnaldo.cursomc.domain.Endereco;
import com.agnaldo.cursomc.domain.Estado;
import com.agnaldo.cursomc.domain.Produto;
import com.agnaldo.cursomc.domain.enuns.TipoCliente;
import com.agnaldo.cursomc.repositories.CategoriaRepository;
import com.agnaldo.cursomc.repositories.CidadeRepository;
import com.agnaldo.cursomc.repositories.ClienteRepository;
import com.agnaldo.cursomc.repositories.EnderecoRepository;
import com.agnaldo.cursomc.repositories.EstadoRepository;
import com.agnaldo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Relacionamento muito para muito craindo categoria e produtos
		 */

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Calçados");

		Produto p1 = new Produto(null, "computador", 2000.00);
		Produto p2 = new Produto(null, "impressora", 500.00);
		Produto p3 = new Produto(null, "mouse", 15.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		/*
		 * Relacionamento um para muitos Criando cidades e estados
		 */

		Cidade cid1 = new Cidade(null, "Teresina");

		Cidade cid2 = new Cidade(null, "Timon");

		Cidade cid3 = new Cidade(null, "Parnaiba");

		Estado est1 = new Estado(null, "Piaui");

		Estado est2 = new Estado(null, "Maranhão");

		cid1.setEstado(est1);
		cid2.setEstado(est2);
		cid3.setEstado(est1);

		est1.getCidades().add(cid1);
		est1.getCidades().add(cid3);
		est2.getCidades().add(cid2);

		estadoRepository.saveAll(Arrays.asList(est1, est2));

		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		/*
		 * Criando cliente com endereco e telefones
		 */
		
		Cliente cliente = new Cliente(null, "Sara", "sara@teste.com", "34343333", TipoCliente.PESSOAFISICA);
	    
		cliente.getTelefones().addAll(Arrays.asList("343434","3434343"));
		
		Endereco end1 = new Endereco(null, "Rua flores", "454", "Comercial flores", "centro", "34343",cliente,cid1);
		
		Endereco end2 = new Endereco(null, "Avenida flores", "434", "Comercial", "centro", "344",cliente,cid1);
		
		cliente.getEnderecos().addAll(Arrays.asList(end1,end2));
		
		clienteRepository.saveAll(Arrays.asList(cliente));

	    enderecoRepository.saveAll(Arrays.asList(end1,end2));
		
		
	}

}
