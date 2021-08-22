<%@ page import="trabalho.entidades.Projeto" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Projetos</title>
</head>
<body>
<header>
    <h1>Listar Projetos</h1>
</header>
<main>
    <section>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Descrição</th>
                <th>Nome</th>
                <th>Pessoa</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (request.getAttribute("listaProjeto")!=null){
                    for (Projeto projeto: (List<Projeto>) request.getAttribute("listaProjeto")){
            %>
            <tr>
                <td><%=projeto.getId()%></td>
                <td><%=projeto.getDescricao()%></td>
                <td><%=projeto.getNome()%></td>
                <td><%=projeto.getPessoa().getNome()%></td>
            </tr>
            <%
                }}
            %>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
