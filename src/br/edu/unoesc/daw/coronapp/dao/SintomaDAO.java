package br.edu.unoesc.daw.coronapp.dao;

import java.util.ArrayList;

import br.edu.unoesc.daw.coronapp.model.Sintoma;

public interface SintomaDAO {
	public boolean insert(final Sintoma sintoma) throws DAOException;
	public boolean update(final Sintoma sintoma) throws DAOException;
	public boolean delete(final Sintoma sintoma) throws DAOException;
	public ArrayList<Sintoma> getAll() throws DAOException;
	public Sintoma getById(int Id) throws DAOException;
}