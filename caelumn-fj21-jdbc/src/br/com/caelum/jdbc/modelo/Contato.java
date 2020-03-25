package br.com.caelum.jdbc.modelo;

import java.util.Calendar;

public final class Contato {
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	public Contato(Long id) {
		this.id = id;
	}
	
	public Contato(String nome, String email, String endereco, Calendar dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public Contato(Long id, String nome, String email, String endereco, Calendar dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public final Long getId() {
		return id;
	}
	
	public final void setId(Long id) {
		this.id = id;
	}
	
	public final String getNome() {
		return nome;
	}
	
	public final void setNome(String nome) {
		this.nome = nome;
	}
	
	public final String getEmail() {
		return email;
	}
	
	public final void setEmail(String email) {
		this.email = email;
	}
	
	public final String getEndereco() {
		return endereco;
	}
	
	public final void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public final Calendar getDataNascimento() {
		return dataNascimento;
	}
	
	public final void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
