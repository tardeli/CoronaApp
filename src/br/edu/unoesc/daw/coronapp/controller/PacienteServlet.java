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
import br.edu.unoesc.daw.coronapp.dao.impl.jdbc.SintomaDAOJdbc;
import br.edu.unoesc.daw.coronapp.dao.impl.jdbc.SintomaPacienteDAOJdbc;
import br.edu.unoesc.daw.coronapp.model.Paciente;
import br.edu.unoesc.daw.coronapp.model.Sintoma;
import br.edu.unoesc.daw.coronapp.model.SintomaPaciente;
import br.edu.unoesc.daw.coronapp.util.DateUtil;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet(urlPatterns = { "/paciente", "/salvarpaciente", "/excluirpaciente"})
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PacienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PacienteDAOJdbc pacienteDAOJdbc = new PacienteDAOJdbc();
		SintomaPacienteDAOJdbc sintomaPacienteDAOJdbc = new SintomaPacienteDAOJdbc();
		HttpSession session = request.getSession(false);
		try {
			Paciente paciente = new Paciente();
			// preciso pegar os da requisição - cadastro do paciente primeiro
			paciente.setNome(request.getParameter("nome"));
			paciente.setDataNascimento(DateUtil.converteStringToDate(request.getParameter("dataNascimento")));
			paciente.setSexo(request.getParameter("sexo").charAt(0));
			paciente.setLatitude(Double.parseDouble(request.getParameter("latitude")));
			paciente.setLongitude(Double.parseDouble(request.getParameter("longitude")));
			pacienteDAOJdbc.insert(paciente);
			// aqui salvou o paciente, agora inserimos os sintomas
			String[] sintomas = request.getParameterValues("sintomas");
			// aqui inserir os sintomas do paciente
			for (String sintoma : sintomas) {
				SintomaPaciente sintomaPaciente = new SintomaPaciente(Integer.parseInt(sintoma), paciente.getCodigo());
				sintomaPacienteDAOJdbc.insert(sintomaPaciente);
			}
			session.setAttribute("msg", "Cadastro realizado com sucesso!");
			response.sendRedirect("/coronapp/paciente");
		} catch (Exception e) {
			session.setAttribute("erro", "Erro ao realizar cadastro do paciente!");
			response.sendRedirect("/coronapp/erro.jsp");
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getRequestURI().endsWith("/paciente")) {
			SintomaDAOJdbc sintomaDAOJdbc = new SintomaDAOJdbc();
			ArrayList<Sintoma> sintomas = sintomaDAOJdbc.getAll();
			request.setAttribute("listaSintomas", sintomas);
			request.getRequestDispatcher("/paciente.jsp").forward(request, response);
		}
		if (request.getRequestURI().endsWith("/excluirpaciente")) {
			PacienteDAOJdbc pacienteDAOJdbc = new PacienteDAOJdbc();
			SintomaPacienteDAOJdbc sintomaPacienteDAOJdbc = new SintomaPacienteDAOJdbc();
			ArrayList<SintomaPaciente> list = new ArrayList<SintomaPaciente>();
			HttpSession session = request.getSession(false);
			try {
				Paciente paciente = new Paciente();
				// preciso pegar os da requisição
				paciente.setCodigo(Integer.valueOf(request.getParameter("codigo")));
				
				// exclui primeiro sintomas paciente
				list = sintomaPacienteDAOJdbc.getPorPaciente(paciente);
				for (SintomaPaciente sintomaPaciente : list) {
					sintomaPacienteDAOJdbc.delete(sintomaPaciente);
				}
				
				// exclui paciente
				pacienteDAOJdbc.delete(paciente);
							
				response.sendRedirect("/coronapp/relatorios/pacientes");
			} catch (Exception e) {
				session.setAttribute("erro", "Erro ao realizar cadastro do paciente!");
				response.sendRedirect("/coronapp/erro.jsp");
			}
		}
	}

}
