<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
		integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<title>GS 2023</title>
</head>

<body>
	<jsp:include page="../relatorioGeral"></jsp:include>

	<div class="container my-4">

		<div class="flex-column" style="width: 100%;">

			<div class="mx-auto">
				<h1 class="title my-5">Tech Med <i class="fa-regular fa-square-plus" style="color: #ff1a1a;"></i></h1>
			</div>

			<div class="form-container p-4 text-center" style="width: 100%;">

				<h2>Relatório Geral</h2>
				<br>
				<c:choose>
					<c:when test="${not empty relatorio}">
						<c:set var="j" value="1" />
						<c:set var="valorTotal" value="0" />
						<table class="table table-hover text-center">
							<thead>
								<tr>
									<th>Quantidade</th>
									<th>Nome do Paciente</th>
									<th>Data</th>
									<th>Nome do Médico</th>
									<th>CRM</th>
									<th>Especialidade</th>
									<th>Valor da Consulta</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="i" items="${relatorio}">
									<c:if test="${i.jaConsultado() eq 'Já realizada'}">
										<tr>
											<td>
												<c:out value="${j}"></c:out>
											</td>
											<td>
												<c:out value="${i.paciente.nome}"></c:out>
											</td>
											<td>
												<c:out value="${i.getFormatData()}"></c:out>
											</td>
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
												R$<fmt:formatNumber type="number" maxFractionDigits="2"
													minFractionDigits="2" value="${i.medico.getValorConsulta()}" />
											</td>
										</tr>
										<c:set var="j" value="${j + 1}" />
										<c:set var="valorTotal" value="${valorTotal + i.medico.getValorConsulta()}" />
									</c:if>
								</c:forEach>
							</tbody>
						</table>

						<p>Valor total arrecadado: <span class="fw-bold">R$
								<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
									value="${valorTotal}" /></span>
					</c:when>
					<c:otherwise>
						<p class="text-center mb-4">Não foi possível fazer o relatório geral </p>
					</c:otherwise>
				</c:choose>

				<br>

				<div style="width: 100%;" class="d-flex justify-content-center">
					<a href="../homePage.jsp" class="submit bg-danger text-center mx-auto"
						style="width: 20%; text-decoration: none; padding: none;">Voltar</a>
				</div>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
	</script>
</body>

</html>