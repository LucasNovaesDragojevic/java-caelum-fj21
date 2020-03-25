package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			Connection connection = new ConnectionFactory().getConnection();
			request.setAttribute("conexao", connection); // Criando atributo para requisição.
			chain.doFilter(request, response); // Prossege para página requisitada.
			connection.close(); // Fecha conexão.
		} catch (SQLException e) {
			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
