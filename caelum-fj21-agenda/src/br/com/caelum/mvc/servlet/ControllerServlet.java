package br.com.caelum.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parametro = req.getParameter("logica"); // Pega parâmetro do navegador chamado "logica".
		String nomeClasse = "br.com.caelum.mvc.logica." + parametro; // Prepara nome da classe que vai instanciar usando conteúdo do parâmetro.
		try {
			Class classe = Class.forName(nomeClasse); // Instancia classe.
			Logica logica = (Logica) classe.newInstance(); // Instancia interface.
			String pagina = logica.executa(req, resp);  // Pega nome da página para redirecionar.
			req.getRequestDispatcher(pagina).forward(req,  resp); // Redireciona página.
		} catch (Exception e) {
			throw new ServletException("[ERRO] Lógica de negócios com problemas ", e);
		}
	}
}