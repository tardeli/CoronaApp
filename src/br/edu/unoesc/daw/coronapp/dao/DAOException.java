/*
 * DAOException.java
 *
 * Created on 20 de Março de 2008, 19:28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.unoesc.daw.coronapp.dao;

/**
 *
 * @author rober
 */
public class DAOException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensagemEspecifica = "";

	/**
	 * Construtor para DAOException.
	 * 
	 * @param msg a mensagem de erro específica.
	 */
	public DAOException(String msg) {
		super(msg);
		this.mensagemEspecifica = msg;
	}

	/**
	 * Construtor para DAOException.
	 * 
	 * @param msg   a mensagem de erro específica.
	 * @param cause a causa raiz da exceção.
	 */
	public DAOException(String msg, Throwable cause) {
		super(msg, cause);
		this.mensagemEspecifica = msg;
	}

	/**
	 * Retorna a mensagem específica do erro
	 * 
	 * @return String.
	 */
	public String getMensagemEspecifica() {
		return this.mensagemEspecifica;
	}
}