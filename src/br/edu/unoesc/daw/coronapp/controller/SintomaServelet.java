package br.edu.unoesc.daw.coronapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.unoesc.daw.coronapp.dao.impl.jdbc.SintomaDAOJdbc;
import br.edu.unoesc.daw.coronapp.model.Sintoma;

/**
 * Servlet implementation class SintomaServelet
 */
@WebServlet("/salvarsintoma")
public class SintomaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SintomaServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SintomaDAOJdbc sintomaDAOJdbc = new SintomaDAOJdbc();
		HttpSession session = request.getSession(false);
		try {
			Sintoma sintoma = new Sintoma();
			
			// preciso pegar os da requisição - cadastro do sintoma
			sintoma.setDescricao((request.getParameter("dessin")));
			
			sintomaDAOJdbc.insert(sintoma);
			
			session.setAttribute("msg", "Cadastro realizado com sucesso!");
			response.sendRedirect("/coronapp/sintoma.jsp");
		} catch(Exception e) {
			session.setAttribute("erro", "Erro ao realizar cadastro do paciente!");
			response.sendRedirect("/coronapp/erro.jsp");
		}
	}

}
