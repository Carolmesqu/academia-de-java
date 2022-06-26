package com.alimentos.Hortifruti.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "hortifruti")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id = null;
	@Column(nullable = false, unique = true)
	private String codigo;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column(nullable = false)
	private String categoria;
	@Column(nullable = false)
	private Float valor;
	@Column(nullable = false)
	private int quantidade;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

}