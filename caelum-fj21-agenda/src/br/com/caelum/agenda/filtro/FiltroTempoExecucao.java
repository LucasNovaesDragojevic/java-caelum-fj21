package br.com.caelum.agenda.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class FiltroTempoExecucao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		long tempoInicial = System.currentTimeMillis(); // Tempo inicial da requisi��o no sistema.
		chain.doFilter(request, response); // Indica que o processamento do request deve prosseguir.
		long tempoFinal = System.currentTimeMillis(); // Tempo final da requisi��o do sistema.
		String uri = ((HttpServletRequest)request).getRequestURI(); // Pega uri requisitada pelo cliente.
		String parametros = ((HttpServletRequest)request).getParameter("logica"); // Pega par�metros requisitados pelo cliente.
		System.out.println("Tempo da requisi��o de " + uri + "?logica=" + parametros + " demorou (ms): " + (tempoFinal - tempoInicial)); // Apresenta resultado.
	}

}
