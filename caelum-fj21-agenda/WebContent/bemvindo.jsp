<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bem vindo</title>
</head>
<body>
	<%-- Comentário em JSP. --%>
	<% String mensagem = "Bem vindo ao sistema de agenda." ;%>
	<% out.println(mensagem);%>
	<br>
	<% String desenvolvido = "Desenvolvido por Lucas Novaes Dragojevic";%>
	<%= desenvolvido %>
	<br>
	<% System.out.println("Tudo foi executado."); %>
</body>
</html>