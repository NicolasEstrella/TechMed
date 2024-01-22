package br.gs.techmed.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.gs.techmed.conexao.Conexao;
import br.gs.techmed.entidade.Medico;

public class MedicoDAO extends DAO{

	public MedicoDAO() {
		this.conexao = new Conexao();
	}
	
	//Método para inserir novo médico no banco de dados
	public void inserir(Medico medico) {

		sql = "insert into gs_medico values(medico_sequence.nextval, ?, ?, ?, ?)";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setString(1, medico.getCrm());
			ps.setString(2, medico.getNome());
			ps.setString(3, medico.getEspecialidade());
			ps.setDouble(4, medico.getValorConsulta());
			ps.execute();

			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao inserir medico\n " + e);
		}
	}
	
	//Método para listar médicos já cadastrados
	public List<Medico> listar() {
		Medico medico = null;
		List<Medico> lista = new ArrayList<>();
		sql = "select * from gs_medico";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				medico = new Medico();
				medico.setId(rs.getInt("medico_id"));
				medico.setCrm(rs.getString("crm"));
				medico.setNome(rs.getString("medico_nome"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setValorConsulta(rs.getDouble("valor_consulta"));
				lista.add(medico);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao listar medicos\n " + e);
		}

		return lista;
	}

	//Método para pesquisar médico
	public Medico pesquisar(Integer id) {
		Medico medico = null;
		sql = "select * from gs_medico where medico_id = ?";
		
		try(Connection connection = conexao.conectar()){
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				medico = new Medico();
				medico.setId(id);
				medico.setNome(rs.getString("medico_nome"));
				medico.setCrm(rs.getString("crm"));
				medico.setEspecialidade(rs.getString("especialidade"));
				medico.setValorConsulta(rs.getDouble("valor_consulta"));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao validar login\n " + e);
		}
		
		return medico;
	}
}
