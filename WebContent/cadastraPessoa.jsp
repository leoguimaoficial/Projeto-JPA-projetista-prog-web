<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Pessoa</title>
</head>
<body>
<header>
    <h1>
        Cadastrar  Pessoa
    </h1>
</header>
<main>
    <section>
        <form action="cadPessoa" method="post">
            <label>Nome: <input type="text" name="txtNome" maxlength="100"></label><br>
<label>Idade <input type="text" name="txtIdade"></label><br>
            
            <label>Sexo <input type="text" name="txtSexo"></label><br>
            <br>
            <input type="submit" value="Cadastrar">
            
        </form>
    </section>
</main>
</body>
</html>
