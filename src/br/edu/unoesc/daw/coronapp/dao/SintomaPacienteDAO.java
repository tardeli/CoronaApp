package br.edu.unoesc.daw.coronapp.dao;

import java.util.ArrayList;

import br.edu.unoesc.daw.coronapp.model.SintomaPaciente;

public interface SintomaPacienteDAO {
	public boolean insert(final SintomaPaciente sintomaPaciente) throws DAOException;

	public boolean delete(final SintomaPaciente sintomaPaciente) throws DAOException;

	public ArrayList<SintomaPaciente> getAll() throws DAOException;
}