/*
 * UsuarioDAO.java
 *
 * Created on 10 de Mar�o de 2008, 19:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.unoesc.daw.coronapp.dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.unoesc.daw.coronapp.dao.UsuarioDAO;
import br.edu.unoesc.daw.coronapp.model.Usuario;

public class UsuarioDAOJdbc implements UsuarioDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public boolean insert(final Usuario usuario) {
		try {
			pstmt = Conexao.getConnection().prepareStatement("insert into usuario(emausu, senusu) " + " values(?,?)");
			pstmt.setString(1, usuario.getEmail());
			pstmt.setString(2, usuario.getSenha());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(final Usuario usuario) {
		try {
			pstmt = Conexao.getConnection()
					.prepareStatement("update usuario set emausu = ?, senusu = ? where codusu = ?");
			pstmt.setString(1, usuario.getEmail());
			pstmt.setString(2, usuario.getSenha());
			pstmt.setInt(3, usuario.getCodigo());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(final Usuario usuario) {
		try {
			pstmt = Conexao.getConnection().prepareStatement("delete from usuario where codusu = ?");
			pstmt.setInt(1, usuario.getCodigo());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Usuario> getAll() {
		try {
			ArrayList<Usuario> listAll = null;
			Usuario usuario = new Usuario();
			pstmt = Conexao.getConnection().prepareStatement("select * from usuario order by nomusu");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listAll = new ArrayList<Usuario>();
				do {
					usuario = new Usuario();
					usuario.setCodigo(rs.getInt("codusu"));
					usuario.setEmail(rs.getString("emausu"));
					usuario.setSenha(rs.getString("senusu"));
					listAll.add(usuario);
				} while (rs.next());
			}
			rs.close();
			pstmt.close();
			return listAll;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Usuario getById(final int Id) {
		try {
			Usuario usuario = null;
			pstmt = Conexao.getConnection().prepareStatement("select * from usuario where codusu = ?");
			pstmt.setInt(1, Id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setCodigo(rs.getInt("codusu"));
				usuario.setEmail(rs.getString("emausu"));
				usuario.setSenha(rs.getString("senusu"));
			}
			rs.close();
			pstmt.close();
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Usuario validaLogin(String email, String senha) {
		try {
			Usuario usuario = null;

			pstmt = Conexao.getConnection().prepareStatement("select * from usuario where emausu = ? and senusu = md5(?)");
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setCodigo(rs.getInt("codusu"));
				usuario.setEmail(rs.getString("emausu"));
				usuario.setSenha(rs.getString("senusu"));
			}

			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}