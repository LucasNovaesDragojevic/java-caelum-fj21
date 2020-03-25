package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteAltera {

	public static void main(String[] args) {
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato(1l, "Osmar", "osm@r.com.br", "Rua Oceano", Calendar.getInstance());
		contatoDao.altera(contato);
	}

}
