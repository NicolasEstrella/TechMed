<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GS 2023</title>
</head>
<body>
	<jsp:include page="../listarMedico"></jsp:include>
	<h2>Pesquisar Consulta</h2>
	<form action="../pesquisarConsulta" method="post">
	<label>Sobre o que era a sua consulta?</label>
		<select name="especialidade">
			<option value="" disabled selected>Opções</option>
			<c:forEach var="i" items="${medicos}">
				<option value="${i.id}"><c:out value="${i.especialidade}"></c:out></option>
			</c:forEach>
		</select>
		<button class="submit">Pesquisar</button>
	</form>
	<c:forEach var="i" items="${consultas}">
	<p> Médico: <c:out value="${i.medico.nome}"></c:out> - <c:out value="${i.medico.especialidade}"></c:out> - <c:out value="${i.getFormatData()}"></c:out> - <c:out value="${i.jaConsultado()}"></c:out></p><br>
	</c:forEach>
</body>
</html>