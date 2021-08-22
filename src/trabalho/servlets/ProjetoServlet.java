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
import trabalho.banco.ProjetoImpl;
import trabalho.entidades.Projeto;

@WebServlet(name = "ProjetoServlet", urlPatterns = "/cadProjeto")
public class ProjetoServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String nome = request.getParameter("txtNome");
		String descricao = request.getParameter("txtDescricao");
		long pessoaId = Long.parseLong(request.getParameter("idPessoa"));


		Projeto projeto = new Projeto(nome, descricao, new PessoaImpl().findById(pessoaId));
		Banco<Projeto> projetoBanco = new ProjetoImpl();
		projetoBanco.insert(projeto);
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Banco<Projeto> projetoBanco = new ProjetoImpl();
		List<Projeto> projetoList = projetoBanco.findAll();
		request.setAttribute("listaProjeto", projetoList);
		getServletContext().getRequestDispatcher("/listarProjeto.jsp").forward(request, response);
	}
}
