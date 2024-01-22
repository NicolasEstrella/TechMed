<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<jsp:include page="./homePage"></jsp:include>
	<jsp:include page="./listarMedico"></jsp:include>

	<c:set var="nome" value="${sessionScope.paciente}" />
	<div class="container d-flex flex-column align-items-start">
		<div class="mx-auto">
			<h1 class="title mb-4">Tech Med <i class="fa-regular fa-square-plus" style="color: #ff1a1a;"></i></h1>
		</div>

		<div class="form-container mx-auto p-3" style="width: 80%;">

			<div class="d-flex">
				<h1 style="border-bottom: 1px solid black; min-width: 35%;">Olá, ${paciente.nome}!</h1>
			</div>

			<c:choose>
				<c:when test="${paciente.login eq 'admin'}">
					<div class="container d-flex align-content-between flex-wrap p-3" style="height: 30%; ">
						<a class="submit m-3 text-center" style="text-decoration: none; width: 25%;"
							href="./form/formCadastrar.jsp">Cadastrar novo paciente</a>
						<a class="submit m-3 text-center" style="text-decoration: none; width: 25%;"
							href="./form/formCadastrarMedico.jsp">Cadastrar novo médico</a>
						<a class="submit m-3 text-center" style="text-decoration: none; width: 25%;"
							href="./form/formPesquisarMedico.jsp">Pesquisar médico</a>
						<a class="submit m-3 text-center" style="text-decoration: none; width: 25%;"
							href="./form/formPesquisarPaciente.jsp">Pesquisar paciente</a>
						<a class="submit m-3 text-center" style="text-decoration: none; width: 25%;"
							href="./form/formRelatorioGeral.jsp">Relatório geral</a>
					</div>
				</c:when>
				<c:otherwise>
					<br>
					<form action="filtrar" method="post">
						<div class="d-flex">
							<select name="medico" class="form-select ms-4"
								style="width: 23%; border: 1px solid #000; margin-right: 5px;margin-right: 5px;">
								<option value="" disabled selected>Escolha um médico</option>
								<c:forEach var="i" items="${medicos}">
									<option value="${i.id}">
										<c:out value="${i.nome}"></c:out> - <c:out value="${i.especialidade}"></c:out>
									</option>
								</c:forEach>
								<option value="0">Mostrar todas as consultas</option>
							</select>
							<button class="submit submit-select">Filtrar consultas</button>
						</div>
					</form>

					<br>

					<c:choose>
						<c:when test="${not empty(requestScope.consultas)}">
							<h4 class="ms-4">Histórico de consultas:</h4>
							<table class="table table-hover text-center">
								<thead>
									<tr>
										<th>Médico</th>
										<th>Especialidade</th>
										<th>Data</th>
										<th>Status</th>
									</tr>
								</thead>
								<tbody>

									<c:forEach var="i" items="${consultas}">
										<tr>
											<td>
												<c:out value="${i.medico.nome}"></c:out>
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
							<p class="text-center fs-3 mt-3">Nenhuma consulta registrada</p>
						</c:otherwise>
					</c:choose>
					<div class="d-flex justify-content-end mt-3">
						<a href="form/formCadastrarConsulta.jsp"><button class="submit" style="width: 100%">Marcar nova
								consulta</button></a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
	</script>
</body>

</html>