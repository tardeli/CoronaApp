package br.edu.unoesc.daw.coronapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unoesc.daw.coronapp.dao.impl.jdbc.UsuarioDAOJdbc;
import br.edu.unoesc.daw.coronapp.model.Usuario;

/**
 * Servlet implementation class AutenticacaoServlet
 */
@WebServlet("/autenticacao")
public class AutenticacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutenticacaoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String erro = "";
		String pagina = "";
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		Usuario usr = new Usuario();
		UsuarioDAOJdbc usrDAO = new UsuarioDAOJdbc();
		try {
			usr = usrDAO.validaLogin(email, senha);
			if (usr != null) {
				request.getSession().setAttribute("email", usr.getEmail());
				pagina = "/index.jsp";
			} else {
				erro = "E-mail e/ou senha inválidos!";
				request.setAttribute("erro", erro);
				pagina = "/erro.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
			pagina = "";
		}

		// redirecionamento é interno
		// processamento é interno
		// a url não muda
		// executado no servidor
		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);
	}

	public void validarSessao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		if (email == null) {
			// Redirecionando pagina
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.forward(request, response);
		}
	}

}
