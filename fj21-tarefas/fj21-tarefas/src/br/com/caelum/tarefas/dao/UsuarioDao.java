package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.com.caelum.tarefas.jdbc.ConnectionFactory;
import br.com.caelum.tarefas.model.Tarefa;
import br.com.caelum.tarefas.model.Usuario;

public class UsuarioDao {
	
	private Connection connection;
	
	public UsuarioDao() throws ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public Boolean existeUsuario (Usuario usuario)
	{		
		try
		{
			PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(idusuarios) FROM fj21.usuarios WHERE login = ? AND senha = ?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.execute();
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
			{
				if (rs.getString(1).equals("1"))
				{
					return true;
				}
			}
			stmt.close();
			rs.close();
		}
		catch (SQLException sqlException)
		{
			throw new RuntimeException(sqlException);
		}
		return false;
	}
}
