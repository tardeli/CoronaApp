package br.edu.unoesc.daw.coronapp.dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.edu.unoesc.daw.coronapp.dao.PacienteDAO;
import br.edu.unoesc.daw.coronapp.model.Paciente;
import br.edu.unoesc.daw.coronapp.model.Sintoma;

public class PacienteDAOJdbc implements PacienteDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public boolean insert(final Paciente paciente) {
		try {
			pstmt = Conexao.getConnection().prepareStatement(
					"insert into paciente(nompac, datnaspac, sexpac, latlocpac, lonlocpac) " + " values(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, paciente.getNome());
			pstmt.setDate(2, new java.sql.Date(paciente.getDataNascimento().getTime()));
			pstmt.setString(3, paciente.getSexo() + "");
			pstmt.setDouble(4, paciente.getLatitude());
			pstmt.setDouble(5, paciente.getLongitude());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			int codigo = -1;
			if (rs.next()) {
				// recupero o código gerado
				codigo = rs.getInt(1);
			}
			paciente.setCodigo(codigo);
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(final Paciente paciente) {
		try {
			pstmt = Conexao.getConnection().prepareStatement(
					"update paciente set nompac = ?, datnaspac = ?, sexpac = ?, latlocpac = ?, lonlocpac = ? where codpac = ?");
			pstmt.setString(1, paciente.getNome());
			pstmt.setDate(2, new java.sql.Date(paciente.getDataNascimento().getTime()));
			pstmt.setString(3, paciente.getSexo() + "");
			pstmt.setDouble(4, paciente.getLatitude());
			pstmt.setDouble(5, paciente.getLongitude());
			pstmt.setInt(6, paciente.getCodigo());
			pstmt.executeUpdate();
			pstmt.close();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(final Paciente paciente) {
		try {
			pstmt = Conexao.getConnection().prepareStatement("delete from paciente where codpac = ?");
			pstmt.setInt(1, paciente.getCodigo());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Paciente> getAll() {
		try {
			ArrayList<Paciente> listAll = null;
			Paciente paciente = new Paciente();
			pstmt = Conexao.getConnection().prepareStatement("select * from paciente order by nompac");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listAll = new ArrayList<Paciente>();
				do {
					paciente = new Paciente();
					paciente.setCodigo(rs.getInt("codpac"));
					paciente.setNome(rs.getString("nompac"));
					paciente.setDataNascimento(rs.getDate("datnaspac"));
					paciente.setSexo(rs.getString("sexpac").charAt(0));
					paciente.setLatitude(rs.getDouble("latlocpac"));
					paciente.setLongitude(rs.getDouble("lonlocpac"));
					paciente.setSintomas(getSintomas(paciente.getCodigo()));
					listAll.add(paciente);
				} while (rs.next());
				
				for (Paciente p : listAll) {
					System.out.println(paciente.toString());
				}
			}
			//rs.close();
			//pstmt.close();
			return listAll;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private ArrayList<Sintoma> getSintomas(int codigoPaciente) {
		ArrayList<Sintoma> sintomas = null;
		try {
			Sintoma sintoma = null;
			PreparedStatement localPstmt = Conexao.getConnection().prepareStatement(
					"select s.* from sintoma s inner join sintoma_paciente sp on s.codsin = sp.codsin where codpac = ?");
			localPstmt.setInt(1, codigoPaciente);
			ResultSet localRs = localPstmt.executeQuery();
			if (localRs.next()) {
				sintomas = new ArrayList<Sintoma>();
				do {
					sintoma = new Sintoma();
					sintoma.setCodigo(localRs.getInt("codsin"));
					sintoma.setDescricao(localRs.getString("dessin"));
					sintomas.add(sintoma);
				} while (localRs.next());
			}
			//localRs.close();
			//localPstmt.close();
			return sintomas;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Paciente getById(final int Id) {
		try {
			Paciente paciente = null;
			pstmt = Conexao.getConnection().prepareStatement("select * from paciente where codpac = ?");
			pstmt.setInt(1, Id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				paciente = new Paciente();
				paciente.setCodigo(rs.getInt("codpac"));
				paciente.setNome(rs.getString("nompac"));
				paciente.setDataNascimento(rs.getDate("datnaspac"));
				paciente.setSexo(rs.getString("sexpac").charAt(0));
				paciente.setLatitude(rs.getDouble("latlocpac"));
				paciente.setLongitude(rs.getDouble("lonlocpac"));
			}
			rs.close();
			pstmt.close();
			return paciente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}