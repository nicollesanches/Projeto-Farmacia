package com.generation.projetofarmacia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do produto é obrigatorio!")
	@Size(min = 5, max = 255, message = "O atributo descrição deve conter no mínimo 05 e no máximo 255 caracteres")
	private String nome;
	
	@NotBlank(message = "O valor do produto é obrigatório!")
	@Size(min = 5, max = 1000, message = "O atributo tipo deve conter no mínimo 05 e no máximo 1000 caracteres")
	private String tipo;
	
	@NotNull(message = "O preço é obrigatório!")
    @DecimalMin(value = "0.01", message = "O atributo 'preço do produto' deve ser um número decimal positivo, a partir de R$ 0.01 !")
    private BigDecimal preco;
	
	@UpdateTimestamp
	private LocalDate data; 

	@ManyToOne
    @JsonIgnoreProperties("produto")
    private Categoria categoria;
	
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}