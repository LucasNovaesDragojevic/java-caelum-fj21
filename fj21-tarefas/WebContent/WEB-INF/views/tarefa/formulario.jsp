<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adicionar Tarefas</title>
</head>
<body>
	<h3>Adicionar Tarefas</h3>
	<form:errors path="tarefa.descricao"></form:errors>
	<form action="adicionaTarefa" method="post">
		Descrição: <br>
		<textarea rows="5" cols="100" name="descricao"></textarea><br>
		<input type="submit" value="Adcionar"/>
	</form>
</body>
</html>