<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<jsp:include page="../listarPaciente"></jsp:include>

	<div class="container d-flex flex-column">

		<div class="mx-auto">
			<h1 class="title mb-5">Tech Med <i class="fa-regular fa-square-plus" style="color: #ff1a1a;"></i></h1>
		</div>

		<form action="../relatorioPaciente" method="post" class="form-container p-4" style="width:45%;">
			<h3 class="text-center">Pesquisar Paciente</h3>

			<div class="d-flex flex-row flex-wrap align-items-center justify-content-center mt-4">
				<label class="fs-5 col-11 mb-4 text-center">Esolha um Paciente para o relatório</label><br>
				<c:forEach var="i" items="${pacientes}">
					<div class="col-6 d-flex flex-column align-items-center justify-content-center text-center">
						<c:out value="${i.nome}"></c:out>
						<br>
						CPF: <c:out value="${i.cpf}"></c:out>
						<br>
						<button style="color: white;width: 50%; background-color: dodgerblue;"
							class="input mb-3 text-center" name="paciente" value="${i.id}">Gerar relatório</button>
					</div>
				</c:forEach>
			</div>

			<a href="../homePage.jsp" class="submit bg-danger text-center mt-4"
				style="width: 30%; text-decoration: none;">Voltar</a>
		</form>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
	</script>
</body>

</html>