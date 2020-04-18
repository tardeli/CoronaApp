package br.edu.unoesc.daw.coronapp.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.unoesc.daw.coronapp.dao.impl.jdbc.Conexao;

/**
 * Servlet Filter implementation class AutenticacaoFilter
 */
@WebFilter(filterName = "AutenticacaoFilter", urlPatterns = { "/*" })
public class AutenticacaoFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AutenticacaoFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Aplicando filtro de autenticacao!!!!!!");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// busca indicador de que o usuario efetuou autenticacao
		String autenticado = (String) req.getSession().getAttribute("email");
		// se nao esta autenticado, pede autenticacao
		if ((autenticado == null)
				&& (req.getRequestURI().indexOf("login") < 0 && req.getRequestURI().indexOf("autenticacao") < 0)) {
			// vai para pagina de autenticação
			res.sendRedirect("/coronapp/login.jsp");
		} else {
			chain.doFilter(request, response); // aplica próximo filtro
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		ServletContext sc = fConfig.getServletContext();
		Conexao.conectar(sc.getInitParameter("url"), sc.getInitParameter("usuario"), sc.getInitParameter("senha"),
				sc.getInitParameter("driver"));
	}

}
