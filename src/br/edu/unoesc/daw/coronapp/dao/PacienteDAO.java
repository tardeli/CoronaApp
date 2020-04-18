package br.edu.unoesc.daw.coronapp.dao;

import java.util.ArrayList;

import br.edu.unoesc.daw.coronapp.model.Paciente;

public interface PacienteDAO {
	public boolean insert(final Paciente paciente) throws DAOException;

	public boolean update(final Paciente paciente) throws DAOException;

	public boolean delete(final Paciente paciente) throws DAOException;

	public ArrayList<Paciente> getAll() throws DAOException;

	public Paciente getById(int Id) throws DAOException;
}