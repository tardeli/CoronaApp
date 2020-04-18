package br.edu.unoesc.daw.coronapp.dao;

import java.util.ArrayList;

import br.edu.unoesc.daw.coronapp.model.Usuario;

public interface UsuarioDAO {
	public boolean insert(final Usuario usuario) throws DAOException;

	public boolean update(final Usuario usuario) throws DAOException;

	public boolean delete(final Usuario usuario) throws DAOException;

	public ArrayList<Usuario> getAll() throws DAOException;

	public Usuario getById(int Id) throws DAOException;
}