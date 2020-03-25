package br.com.caelum.jdbc.teste;

import java.util.Calendar;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {

			// Criando classe para inserir no banco.
			Contato contato = new Contato("Jussara", "jus@sara.com.br", "Rua dos limões, 654, Vila Citrica, Lima, Acre", Calendar.getInstance());
			// Classe para conexão.
			ContatoDao contatoDao = new ContatoDao();
			// Adicionando do banco.
			contatoDao.adiciona(contato);
			System.out.println("Gravado");
	}
}