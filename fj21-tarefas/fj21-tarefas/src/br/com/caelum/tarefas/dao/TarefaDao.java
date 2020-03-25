package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import br.com.caelum.tarefas.jdbc.ConnectionFactory;
import br.com.caelum.tarefas.model.Tarefa;

public class TarefaDao {
	private Connection connection;
	private List<Tarefa> lista = new ArrayList<>();
	private Calendar data = Calendar.getInstance();
	
	public TarefaDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona (Tarefa tarefa)
	{
		String sql = "INSERT INTO fj21.tarefas" + "(descricao, finalizado, dataFinalizacao)" + " VALUES (?, ?, ?)";
		try
		{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tarefa.getDescricao());
			stmt.setBoolean(2, tarefa.getFinalizado());
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		}
		catch (SQLException sqlException)
		{
			throw new RuntimeException(sqlException);
		}
	}
	
	public List<Tarefa> lista()
	{
		try
		{
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM fj21.tarefas");
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				data.setTime(rs.getDate("dataFinalizacao"));
				Tarefa tarefa = new Tarefa(rs.getLong("id"), rs.getString("descricao"), rs.getBoolean("finalizado"), data);
				lista.add(tarefa);
			}
			rs.close();
			stmt.close();
			return lista;
		}
		catch (SQLException sqlExcetption)
		{
			throw new RuntimeException(sqlExcetption);
		}
	}
	
	public void remove(Tarefa tarefa)
	{
		try
		{
			PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM fj21.tarefas WHERE id = ?");
			stmt.setLong(1, tarefa.getId());
			stmt.execute();
			stmt.close();
		}
		catch (SQLException sqlExcetption)
		{
			throw new RuntimeException(sqlExcetption);
		}
	}
	
	public Tarefa buscarPorId(Long id)
	{
		try
		{
			Tarefa tarefa = null;
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM fj21.tarefas WHERE id = ?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				data.setTime(rs.getDate("dataFinalizacao"));
				tarefa = new Tarefa(rs.getLong("id"), rs.getString("descricao"), rs.getBoolean("finalizado"), data);
			}
			rs.close();
			stmt.close();
			return tarefa;
		}
		catch (SQLException sqlExcetption)
		{
			throw new RuntimeException(sqlExcetption);
		}
	}
	
	public void altera(Tarefa tarefa)
	{
		
		System.out.println(tarefa.getFinalizado());
		try
		{
			PreparedStatement stmt = this.connection.prepareStatement("UPDATE fj21.tarefas SET descricao = ?, finalizado = ?, dataFinalizacao = ? WHERE id = ?");
			stmt.setString(1, tarefa.getDescricao());
			stmt.setString(2, tarefa.getFinalizado() ? "1" : "0");
			stmt.setDate(3, new Date(tarefa.getDataFinalizacao().getTimeInMillis()));
			stmt.setLong(4, tarefa.getId());
			stmt.execute();
			stmt.close();
		}
		catch (SQLException sqlExcetption)
		{
			throw new RuntimeException(sqlExcetption);
		}
	}

	public void finaliza(Long id)
	{
		try
		{
			PreparedStatement stmt = this.connection.prepareStatement("UPDATE fj21.tarefas SET finalizado = '1' WHERE id = ?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			System.out.println("finaliza dao");
		}
		catch (SQLException sqlExcetption)
		{
			throw new RuntimeException(sqlExcetption);
		}
	}
}
