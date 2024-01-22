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

		<div class="form-container p-4" style="width: 50%;">

			<h3 class="text-center mb-4">Relatório do(a) médico(a) ${medico.nome} - ${medico.especialidade}</h3>

			<c:choose>
				<c:when test="${not empty(requestScope.relatorio)}">
					<table class="table table-hover text-center">
						<thead>
							<tr>
								<th>Quantidade</th>
								<th>Nome do Paciente</th>
								<th>Data</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="j" value="1" />
							<c:forEach var="i" items="${relatorio}">
								<c:if test="${i.jaConsultado() eq 'Já realizada'}">
									<c:set var="nomePaciente" value="${i.paciente.getNome()}" />
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
									</tr>
									<c:set var="j" value="${j + 1}" />
								</c:if>
							</c:forEach>
						</tbody>
					</table>
					<c:set var="valor" value="${relatorio[0].medico.getValorConsulta() * (j - 1)}"></c:set>

					<br>
						<div class="d-flex mb-3">
							<p class="me-auto">Valor por consulta: <span class="fw-bold">R$
								<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
									value="${relatorio[0].medico.getValorConsulta()}" /></span>
							</p>

							<p>O(A) médico(a) ${relatorio[0].medico.getNome()} irá receber:
								<span class="fw-bold">R$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2"
									value="${valor}" /></p></span>
							</p>
						</div>
				</c:when>
				<c:otherwise>
					<p class="mb-4 text-center">Nenhuma consulta foi feita com esse médico ainda </p>
				</c:otherwise>

			</c:choose>
			<div style="width: 100%;" class="d-flex justify-content-center">
				<a href="form/formPesquisarMedico.jsp" class="submit bg-danger text-center mx-auto"
				style="width: 40%; text-decoration: none; padding: none;">Voltar</a>
			</div>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
	</script>
</body>

</html>