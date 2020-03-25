package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteRemove {

	public static void main(String[] args) {
		ContatoDao contatoDao = new ContatoDao();
		Contato contato = new Contato(1l);
		contatoDao.remove(contato);
	}

}
