package br.edu.unoesc.daw.coronapp.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unoesc.daw.coronapp.dao.impl.jdbc.PacienteDAOJdbc;
import br.edu.unoesc.daw.coronapp.model.Paciente;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet(urlPatterns = { "/relatorios/pacientes" })
public class RelatoriosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RelatoriosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (request.getRequestURI().contains("/pacientes")) {
			session.setAttribute("relacaoPacientes", getRelacaoPacientes());
			response.sendRedirect("/coronapp/relatorios/relacaoPacientes.jsp");
		}
	}

	private ArrayList<Paciente> getRelacaoPacientes() {
		PacienteDAOJdbc pacienteDAOJdbc = new PacienteDAOJdbc();
		return pacienteDAOJdbc.getAll();
	}

}
