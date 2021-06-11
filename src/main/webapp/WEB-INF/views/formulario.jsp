<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Morador</title>
</head>
<body>

	<!-- action="cadastro" é o path absoluto -->
	<form:form method="POST" modelAttribute="morador" action="cadastro">

		<p>Nome:</p>
		<form:input path="nome" />

		<p>Local:</p>
		<form:input path="local" />

		<form:button>Enviar</form:button>

		<p>${mensagem}</p>
	</form:form>

	<table>
		<thead>
			<tr>
				<th>NOME</th>
				<th>LOCAL</th>
				<th>AÇÃO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="morador" items="${moradores}">
				<tr>
					<td>${morador.nome}</td>
					<td>${morador.local}</td>
					<td><a href="editar/${morador.id}">Editar</a> <a
						href="excluir/${morador.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>