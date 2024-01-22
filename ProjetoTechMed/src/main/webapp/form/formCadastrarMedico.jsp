<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="container d-flex flex-column">

        <div class="mx-auto">
            <h1 class="title mb-4">Tech Med <i class="fa-regular fa-square-plus" style="color: #ff1a1a;"></i></h1>
        </div>

        <form class="form-container p-4 d-flex flex-column justify-content-center" action="../CadastrarMedico" method="post">
            <h2 class="text-center mb-3">Cadastre um novo médico</h2>
            <label class="mx-auto mt-2">
                <span>Nome:</span><br>
                <input class="input" type="text" placeholder="Nome do Médico" required="required" name="nome">
            </label>
            <label class="mx-auto">
                <span>CRM:</span><br>
                <input class="input" type="text" placeholder="RM00000" required="required" name="crm">
            </label>
            <label class="mx-auto">
                <span>Especialidade:</span><br>
                <input class="input" type="text" placeholder="Área de atuação" required="required" name="especialidade">
            </label>
            <label class="mx-auto">
                <span>Valor da consulta:</span><br>
                <input class="input" type="number" placeholder="800,00" required="required" name="valor_consulta" step="0.01">
            </label>
            <div class="d-flex justify-content-between mt-3">
                <a href="../homePage.jsp" class="submit bg-danger text-center"
                    style="width: 30%; text-decoration: none;">Voltar</a>
                <button class="submit" style="padding: none;">Enviar</button>
            </div>
        </form>
    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
    </script>
</body>

</html>