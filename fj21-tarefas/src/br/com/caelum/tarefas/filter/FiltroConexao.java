package br.com.caelum.tarefas.filter;
 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import br.com.caelum.tarefas.jdbc.ConnectionFactory;
 
@WebFilter("/*")
public class FiltroConexao implements Filter {
 
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            Connection connection = new ConnectionFactory().getConnection();
            request.setAttribute("conexao", connection); // Criando atributo para requisi��o.
            chain.doFilter(request, response); // Prossege para p�gina requisitada.
            connection.close(); // Fecha conex�o.
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}