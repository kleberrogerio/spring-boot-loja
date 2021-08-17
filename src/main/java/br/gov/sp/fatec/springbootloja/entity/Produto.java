<<<<<<< HEAD
package br.gov.sp.fatec.springbootloja.entity;

public class Produto {

=======
package br.edu.fatecsjc.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pro_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private Long id;
	
	@Column(name ="pro_nome")
	private String nome;
	
	@Column(name ="pro_preco")
	private BigDecimal preco;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mar_id")
	private Marca marca;
	
	@ManyToMany(mappedBy = "produtos", fetch = FetchType.LAZY)
	private Set<Venda> vendas;

	public Set<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(Set<Venda> vendas) {
		this.vendas = vendas;
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
>>>>>>> 3d6f07463dbd4f0d4bdd810f6d7be69998634763
}
