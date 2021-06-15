<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Usuário</title>
</head>
<body>
	<form:form method="POST" modelAttribute="user"
		action="../update/${id}">
		<p>Nome:</p>
		<form:input path="name" />

		<p>Local:</p>
		<form:input path="local" />
		
		<form:button>Enviar</form:button>
	</form:form>

</body>
</html>