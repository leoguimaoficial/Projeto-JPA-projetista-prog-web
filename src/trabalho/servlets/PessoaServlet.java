package trabalho.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trabalho.banco.Banco;
import trabalho.banco.PessoaImpl;
import trabalho.entidades.Pessoa;

@WebServlet(name = "PessoaServlet", urlPatterns = "/cadPessoa")
public class PessoaServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String nome = request.getParameter("txtNome");
		String idade = request.getParameter("txtIdade");

		String sexo = request.getParameter("txtSexo");

		Pessoa pessoa = new Pessoa(nome, idade, sexo);
		Banco<Pessoa> pessoaBanco = new PessoaImpl();
		pessoaBanco.insert(pessoa);
		doGet(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco<Pessoa> pessoaBanco = new PessoaImpl();
		List<Pessoa> pessoaList = pessoaBanco.findAll();
		request.setAttribute("listaPessoa", pessoaList);
		getServletContext().getRequestDispatcher("/listarPessoas.jsp").forward(request, response);
	}
}
