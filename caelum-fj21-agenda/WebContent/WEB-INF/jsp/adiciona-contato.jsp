<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adiciona Contatos</title>
<link href="css/jquery-ui.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<h1>Adiciona Contatos</h1>
	<hr/>
	<form action="adicionaContato">
	    Nome: <input type="text" name="nome" /><br/>
	    E-mail: <input type="text" name="email" /><br/>
	    Endere�o: <input type="text" name="endereco" /><br/>
	    Data Nascimento: <tags:campoData id="dataNascimento"/><br >
	    <input type="submit" value="Gravar" />
	</form>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>