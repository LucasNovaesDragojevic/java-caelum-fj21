package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public final class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "INSERT INTO fj21.contatos" + "(nome, email, endereco, dataNascimento)" + " VALUES (?, ?, ?, ?)";
		try {
			// Prepara a declaração da consulta.
			PreparedStatement stmt = connection.prepareStatement(sql);
			// Seta os valores na declaração.
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date (contato.getDataNascimento().getTimeInMillis()));
			// Executa a inserção.
			stmt.execute();
			stmt.close();
		} catch (SQLException sqlException) {
			throw new RuntimeException(sqlException);
		}
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM fj21.contatos");
			ResultSet rs = stmt.executeQuery(); // Pegando resposta do banco.
			// Andando por cada registro coletado.
			while (rs.next()) {
				// Criando calendario para conversão do banco.
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				// Criando contato a partir dos dados do banco.
				Contato contato = new Contato(rs.getLong("id"), rs.getString("nome"), rs.getString("email"), rs.getString("endereco"), data);
				// Adicionando registro a lista local.
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException sqlException) {
			throw new RuntimeException(sqlException);
		}
	}

	public void altera(Contato contato) {
		String sql = "UPDATE fj21.contatos SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException sqlException) {
			throw new RuntimeException(sqlException);
		}
	}
	
	public void remove(Contato contato) {
		try {
			String sql = "DELETE FROM fj21.contatos WHERE id = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException sqlException) {
			throw new RuntimeException(sqlException);
		}
	}
}