package br.edu.unoesc.daw.coronapp.dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.edu.unoesc.daw.coronapp.dao.SintomaPacienteDAO;
import br.edu.unoesc.daw.coronapp.model.SintomaPaciente;

public class SintomaPacienteDAOJdbc implements SintomaPacienteDAO {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public boolean insert(final SintomaPaciente sintomaPaciente) {
		try {
			pstmt = Conexao.getConnection().prepareStatement("insert into sintoma_paciente values(?,?)");
			pstmt.setInt(1, sintomaPaciente.getCodigoSintoma());
			pstmt.setInt(2, sintomaPaciente.getCodigoPaciente());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(final SintomaPaciente sintomaPaciente) {
		try {
			pstmt = Conexao.getConnection()
					.prepareStatement("delete from sintoma_paciente where codsin = ? and codpac = ?");
			pstmt.setInt(1, sintomaPaciente.getCodigoSintoma());
			pstmt.setInt(2, sintomaPaciente.getCodigoPaciente());
			pstmt.executeUpdate();
			pstmt.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<SintomaPaciente> getAll() {
		try {
			ArrayList<SintomaPaciente> listAll = null;
			SintomaPaciente sintomaPaciente = new SintomaPaciente();
			pstmt = Conexao.getConnection().prepareStatement("select * from sintoma_paciente");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listAll = new ArrayList<SintomaPaciente>();
				do {
					sintomaPaciente = new SintomaPaciente();
					sintomaPaciente.setCodigoSintoma(rs.getInt("codsin"));
					sintomaPaciente.setCodigoPaciente(rs.getInt("codpac"));
					listAll.add(sintomaPaciente);
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

}