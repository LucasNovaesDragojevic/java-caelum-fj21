package br.com.caelum.tarefas.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() throws ClassNotFoundException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useTimezone=true&serverTimezone=UTC&useSSL=false", "lucas", "Mudar#321");
		}
		catch (SQLException exception)
		{
			throw new RuntimeException(exception);
		}
	}
}
