/**
 * 
 */
package br.edu.unoesc.daw.coronapp.model;

/**
 * Classe SintomaPaciente
 * 
 * @author rober
 *
 */
public class SintomaPaciente {
	private Integer codigoSintoma;
	private Integer codigoPaciente;

	public SintomaPaciente() {
	}

	public SintomaPaciente(Integer codigoSintoma, Integer codigoPaciente) {
		this.codigoSintoma = codigoSintoma;
		this.codigoPaciente = codigoPaciente;
	}

	/**
	 * @return the codigoSintoma
	 */
	public Integer getCodigoSintoma() {
		return codigoSintoma;
	}

	/**
	 * @param codigoSintoma the codigoSintoma to set
	 */
	public void setCodigoSintoma(Integer codigoSintoma) {
		this.codigoSintoma = codigoSintoma;
	}

	/**
	 * @return the codigoPaciente
	 */
	public Integer getCodigoPaciente() {
		return codigoPaciente;
	}

	/**
	 * @param codigoPaciente the codigoPaciente to set
	 */
	public void setCodigoPaciente(Integer codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

}
