package br.edu.unoesc.daw.coronapp.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe Paciente
 * 
 * @author rober
 *
 */
public class Paciente {
	private Integer codigo;
	private String nome;
	private Date dataNascimento;
	private char sexo;
	private Double latitude;
	private Double longitude;
	private volatile ArrayList<Sintoma> sintomas = new ArrayList<Sintoma>();

	
	
	public Paciente() {
	
	}

	public Paciente(Integer codigo, String nome, Date dataNascimento, char sexo, Double latitude, Double longitude) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.latitude = latitude;
		this.longitude = longitude;
	
	}
	
	public void getAdicionar(Sintoma sintoma){
		this.sintomas.add(sintoma);
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the sintomas
	 */
	public String getSintomas() {
		StringBuffer sBuffer = new StringBuffer();
		for (Sintoma sintoma : sintomas) {
			sBuffer.append(sintoma.getDescricao() + ", ");
		}
		return sBuffer.toString().substring(0, sBuffer.length() - 2);
	}

	/**
	 * @param sintomas the sintomas to set
	 */
	public void setSintomas(ArrayList<Sintoma> sintomas) {
		this.sintomas = sintomas;
	}

}
