package br.com.caelum.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory
{
	public Connection getConnection() throws ClassNotFoundException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/MYSQL?useTimezone=true&serverTimezone=UTC", "lucas", "Mudar#321");
		}
		catch (SQLException exception)
		{
			throw new RuntimeException(exception);
		}
	}
}