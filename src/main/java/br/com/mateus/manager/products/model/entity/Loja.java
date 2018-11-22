package br.com.mateus.manager.products.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "razao_social")
	private String razaoSocial;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "loja_fk"))
	private Endereco endereco;
	@ManyToMany
	private List<Produto> produtos;
	private String cnpj;

	public Loja() {

	}

	public Loja(String razaoSocial, Endereco endereco, String cnpj) {
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
		this.cnpj = cnpj;
	}
}
