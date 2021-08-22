<%@ page import="trabalho.entidades.Pessoa" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Pessoas</title>
</head>
<body>
<header>
    <h1>Listar Pessoa</h1>
</header>
<main>
    <section>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Idade</th>
                <th>Sexo</th>
            </tr>
            </thead>
            <tbody>
            <%
                if (request.getAttribute("listaPessoa")!=null){
                    for (Pessoa pessoa: (List<Pessoa>) request.getAttribute("listaPessoa")){
            %>
                <tr>
                    <td><%=pessoa.getId()%></td>
                    <td><%=pessoa.getNome()%></td>
                    <td><%=pessoa.getIdade()%></td>
                    <td><%=pessoa.getSexo()%></td>
                </tr>

            <%
                    }
                }
            %>
            </tbody>
        </table>
    </section>
</main>
</body>
</html>
