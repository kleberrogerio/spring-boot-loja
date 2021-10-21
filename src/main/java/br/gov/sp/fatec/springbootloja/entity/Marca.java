package br.gov.sp.fatec.springbootloja.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.springbootloja.controller.View;

@Entity
@Table(name = "mar_marca")
public class Marca {
	
	@JsonView({View.MarcaResumo.class,View.ProdutoResumo.class})
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mar_id")
	private Long id;
	
	@JsonView({View.MarcaResumo.class,View.ProdutoResumo.class})
	@Column(name ="mar_nome")
	private String nome;
	
	@JsonView(View.MarcaResumo.class)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "marca")
	private Set<Produto> produtos;

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
