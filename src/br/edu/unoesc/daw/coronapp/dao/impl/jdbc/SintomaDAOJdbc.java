package br.edu.unoesc.daw.coronapp.dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.unoesc.daw.coronapp.dao.SintomaDAO;
import br.edu.unoesc.daw.coronapp.model.Sintoma;

public class SintomaDAOJdbc implements SintomaDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public boolean insert(final Sintoma sintoma) {
		try {
			pstmt = Conexao.getConnection().prepareStatement("insert into sintoma(dessin) " + " values(?)");
			pstmt.setString(1, sintoma.getDescricao());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(final Sintoma sintoma) {
		try {
			pstmt = Conexao.getConnection().prepareStatement("update sintoma set dessin = ? where codsin = ?");
			pstmt.setString(1, sintoma.getDescricao());
			pstmt.setInt(3, sintoma.getCodigo());
			pstmt.executeUpdate();
			pstmt.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(final Sintoma sintoma) {
		try {
			pstmt = Conexao.getConnection().prepareStatement("delete from sintoma where codsin = ?");
			pstmt.setInt(1, sintoma.getCodigo());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Sintoma> getAll() {
		try {
			ArrayList<Sintoma> listAll = null;
			Sintoma sintoma = new Sintoma();
			pstmt = Conexao.getConnection().prepareStatement("select * from sintoma order by dessin");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listAll = new ArrayList<Sintoma>();
				do {
					sintoma = new Sintoma();
					sintoma.setCodigo(rs.getInt("codsin"));
					sintoma.setDescricao(rs.getString("dessin"));
					listAll.add(sintoma);
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

	public Sintoma getById(final int Id) {
		try {
			Sintoma sintoma = null;
			pstmt = Conexao.getConnection().prepareStatement("select * from sintoma where codsin = ?");
			pstmt.setInt(1, Id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sintoma = new Sintoma();
				sintoma.setCodigo(rs.getInt("codsin"));
				sintoma.setDescricao(rs.getString("dessin"));
			}
			rs.close();
			pstmt.close();
			return sintoma;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}