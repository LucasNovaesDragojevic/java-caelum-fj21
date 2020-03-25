package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class RemoveContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long id = Long.parseLong(request.getParameter("id"));
		Contato contato = new Contato(id);
		Connection connection = (Connection) request.getAttribute("conexao"); // Pegando conexão do filtro.
		ContatoDao contatoDao = new ContatoDao(connection);
		contatoDao.remove(contato);
		System.out.println("Excluindo contato...");
		return "mvc?logica=ListaContatosLogica";
	}
}