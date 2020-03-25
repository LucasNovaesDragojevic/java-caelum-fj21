<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="br.com.caelum.jdbc.dao.*" %>
<%@ page import="br.com.caelum.jdbc.modelo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de contatos</title>
</head>
<body>
	<table>
		<%
			ContatoDao contatoDao = new ContatoDao();
			List<Contato> contatos = contatoDao.getLista();
			for (Contato contato : contatos) {
		%>
		<tr>
			<td><%=contato.getNome()%></td>
			<td><%=contato.getEmail()%></td>
			<td><%=contato.getEndereco()%></td>
			<td><%=contato.getDataNascimento().getTime()%></td>
		</tr>
		<% } %>
	</table>
</body>
</html>