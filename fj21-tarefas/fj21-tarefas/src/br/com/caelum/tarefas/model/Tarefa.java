package br.com.caelum.tarefas.model;

import java.util.Calendar;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Tarefa {
	private Long id;
	@Size(min=5) private String descricao;
	private Boolean finalizado = false;
	@DateTimeFormat(pattern="dd/MM/yyyy") private Calendar dataFinalizacao = Calendar.getInstance();
	
	public Tarefa()	{
		
	}
	
	public Tarefa(Long id, String descricao, Boolean finalizado, Calendar dataFinalizacao) {
		this.id = id;
		this.descricao = descricao;
		this.finalizado = finalizado;
		this.dataFinalizacao = dataFinalizacao;
	}
	
	public Long getId () {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Boolean getFinalizado() {
		return finalizado;
	}
	
	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}
	
	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}
}
