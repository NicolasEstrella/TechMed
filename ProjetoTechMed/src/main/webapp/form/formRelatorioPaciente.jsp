<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
		integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<title>GS 2023</title>
</head>

<body>
	<div class="container d-flex flex-column">

		<div class="mx-auto">
			<h1 class="title mb-5">Tech Med <i class="fa-regular fa-square-plus" style="color: #ff1a1a;"></i></h1>
		</div>

		<div class="form-container p-4 text-center" style="width: 80%;">

			<h2>Relatório do(a) paciente ${paciente.nome}</h2>

			<c:choose>
				<c:when test="${not empty(requestScope.relatorio)}">
					<table class="table table-hover text-center my-5">
						<thead>
							<tr>
								<th>Médico</th>
								<th>CRM</th>
								<th>Especialidade</th>
								<th>Data</th>
								<th>Status</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${relatorio}">
								<tr>
									<td>
										<c:out value="${i.medico.nome}"></c:out>
									</td>
									<td>
										<c:out value="${i.medico.crm}"></c:out>
									</td>
									<td>
										<c:out value="${i.medico.especialidade}"></c:out>
									</td>
									<td>
										<c:out value="${i.getFormatData()}"></c:out>
									</td>
									<td>
										<c:out value="${i.jaConsultado()}"></c:out>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<p>Nenhuma consulta registrada com esse paciente ainda </p>
				</c:otherwise>
			</c:choose>
			<div style="width: 100%;" class="d-flex justify-content-center">
				<a href="form/formPesquisarPaciente.jsp" class="submit bg-danger text-center mx-auto"
					style="width: 20%; text-decoration: none; padding: none;">Voltar</a>
			</div>
		</div>

	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
	</script>
</body>

</html>