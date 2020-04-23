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
import br.edu.unoesc.daw.coronapp.model.Sintoma;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet(urlPatterns = { "/relatorios/pacientes", "/relatorios/idade", "/relatorios/sintomas"})
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
		
		if (request.getRequestURI().contains("/idade")) {
			session.setAttribute("relacaoPacientesIdade", getRelacaoPacientesIdade_20_a_30());
			response.sendRedirect("/coronapp/relatorios/relacaoPacientesIdade.jsp");
		}
		
		if (request.getRequestURI().contains("/sintomas")) {
			session.setAttribute("relacaoPacientesIdadeSintomas", getRelacaoPacientesIdade_60_Sintomas());
			response.sendRedirect("/coronapp/relatorios/relacaoPacientesIdadeSintomas.jsp");
		}
	}

	private ArrayList<Paciente> getRelacaoPacientes() {
		PacienteDAOJdbc pacienteDAOJdbc = new PacienteDAOJdbc();
		return pacienteDAOJdbc.getAll();
	}
	
	private ArrayList<Paciente> getRelacaoPacientesIdade_20_a_30() {
		PacienteDAOJdbc pacienteDAOJdbc = new PacienteDAOJdbc();
		return pacienteDAOJdbc.getPacienteEntre_20_30_Anos();
	}
	
	private ArrayList<Paciente> getRelacaoPacientesIdade_60_Sintomas() {
		PacienteDAOJdbc pacienteDAOJdbc = new PacienteDAOJdbc();
		ArrayList<Paciente> pacienteRetorno = new ArrayList<Paciente>();
		
		if(pacienteDAOJdbc.getPacienteAcima_60_Anos_ComSintomas()!=null) {
			for (Paciente paciente : pacienteDAOJdbc.getPacienteAcima_60_Anos_ComSintomas()) {
				if((paciente.getSintomas().contains("Febre")) && (paciente.getSintomas().contains("Dificuldade de respirar")) && (paciente.getSintomas().contains("Náuseas"))){
					pacienteRetorno.add(paciente); 
				}
			}
		}
		
		return pacienteRetorno;
	}

}
