<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container">
		<div class="form-container p-4">

			<form class="d-flex flex-column" action="./Login" method="post">
				<h1 class="title mb-4">Tech Med <i class="fa-regular fa-square-plus" style="color: #ff1a1a;"></i></h1>

				<label class="mx-auto">
					<span>Login</span><br>
					<input class="input p-2" type="text" placeholder="SeuLogin" required="required" name="login">
				</label>
				<label class="mx-auto">
					<span>Senha</span><br>
					<input class="input p-2" type="password" placeholder="*******" required="required" name="senha">
				</label>
				<button class="submit mx-auto mt-3 mb-3">Entrar</button>
				<p class="signin">
					Não possui uma conta? <a href="./form/formCadastrar.jsp">Registre-se</a>
				</p>
			</form>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
	</script>
</body>

</html>