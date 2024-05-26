package br.com.SchusterSystem.models;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;
	
	private Integer quantidade;
	private Double  valor;

	public Produto( ) {}

	
	
	public Produto(Long id, String nome, Integer quantidade, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public Produto toProduto() {
		
		Produto produto = new Produto();
		produto.setNome(this.nome);
		produto.setQuantidade(this.quantidade);
		produto.setValor(this.valor);

		return produto;
	}
	
	public void fromProduto(Produto produto) {
		
		produto.setNome(this.nome);
		produto.setQuantidade(this.quantidade);
		produto.setValor(this.valor);

		
	}
	
	public Produto toProdutoAtualizar(Produto produto) {
		
		produto.setNome(this.nome);
		produto.setQuantidade(this.quantidade);
		produto.setValor(this.valor);
		return produto;
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

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
