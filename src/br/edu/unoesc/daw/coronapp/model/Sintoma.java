package br.edu.unoesc.daw.coronapp.model;

/**
 * Classe Sintoma
 * 
 * @author rober
 *
 */
public class Sintoma {
	private Integer codigo;
	private String descricao;
	
	public Sintoma() {
		// TODO Auto-generated constructor stub
	}
	
	public Sintoma(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}


	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
