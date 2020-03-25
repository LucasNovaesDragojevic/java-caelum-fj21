package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AdicionaContatoLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		Calendar dataNascimento = Calendar.getInstance();
		Contato contato = new Contato(nome, email, endereco, dataNascimento);		
		Connection connection = (Connection) request.getAttribute("conexao"); // Pegando conexão do filtro.
		ContatoDao contatoDao = new ContatoDao(connection);
		contatoDao.adiciona(contato);
		System.out.println("Adicionando contato...");
		return "mvc?logica=ListaContatosLogica";
	}
}