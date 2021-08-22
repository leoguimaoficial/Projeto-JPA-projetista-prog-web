<%@ page import="java.util.List" %>
<%@ page import="trabalho.entidades.Pessoa" %>
<%@ page import="trabalho.banco.Banco" %>
<%@ page import="trabalho.banco.PessoaImpl" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Projetos</title>
</head>
<body>
<header>
    <h1>Cadastrar Projeto</h1>
</header>
<>
    <section>
        <form action="cadProjeto" method="post">
            <label>Nome: <input type="text" name="txtNome"></label><br>
            <label>Descrição <input type="text" name="txtDescricao"></label><br>
            <label for="pessoa">Pessoas</label>
            <select name="idPessoa" id="pessoa">
                <option value="" selected>-----------------</option>
                <%
                    Banco<Pessoa> pessoaBanco = new PessoaImpl();

                    List<Pessoa> pessoaList = pessoaBanco.findAll();
                    for (Pessoa pessoa: pessoaList){
                %>
                <option value="<%=pessoa.getId()%>"><%=pessoa.getNome()%></option>
                <%
                    }
                %>
            </select>
            <br><br>
            <input type="submit" value="Cadastrar">
        </form>
    </section>
</main>
</body>
</html>
