<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="br.com.caelum.jdbc.dao.*" %>
<%@ page import="br.com.caelum.jdbc.modelo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de contatos</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>E-mail</th>
			<th>Endereco</th>
			<th>Data Nascimento</th>
		</tr>
		<c:forEach var="contato" items="${contatos}" varStatus="id">
			<tr>
				<td>${id.count}</td>
				<td>${contato.nome}</td>
				<td>
					<c:choose>
						<c:when test="${not empty contato.email}">
							<a href="mailto:${contato.email}">${contato.email}</a>
						</c:when>
						<c:otherwise>
							E-mail não informado.
						</c:otherwise>
					</c:choose>
				</td>
				<td>${contato.endereco}</td>
				<td><fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
				<td><a href = "mvc?logica=RemoveContatoLogica&id=${contato.id}">Remover</a></td>
			</tr>
		</c:forEach>
	</table>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>