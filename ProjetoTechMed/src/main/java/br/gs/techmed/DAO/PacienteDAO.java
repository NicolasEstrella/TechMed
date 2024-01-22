package br.gs.techmed.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.gs.techmed.conexao.Conexao;
import br.gs.techmed.entidade.Consulta;
import br.gs.techmed.entidade.Medico;
import br.gs.techmed.entidade.Paciente;

public class PacienteDAO extends DAO {

	public PacienteDAO() {
		this.conexao = new Conexao();
	}
	
	// método para inserir um contato na tabela
	public void inserir(Paciente paciente) {
		
		sql = "insert into gs_paciente values(paciente_sequence.nextval, ?, ?, ?, ?, ?)";

		try(Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);			
			ps.setString(1, paciente.getNome());
			ps.setString(2, paciente.getCpf());
			ps.setString(3, paciente.getEmail());
			ps.setString(4, paciente.getLogin());
			ps.setString(5, paciente.getSenha());
			ps.execute();
			
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao inserir paciente\n " + e);
		}
	}
	//Método para validar o login do usuário
	public Paciente validar(String login, String senha) {
		Paciente paciente = null;
		sql = "select * from gs_paciente where login = ? and senha = ?";
		
		try(Connection connection = conexao.conectar()){
			ps = connection.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()) {
				paciente = new Paciente();
				paciente.setId(rs.getInt("paciente_id"));
				paciente.setNome(rs.getString("paciente_nome"));
				paciente.setEmail(rs.getString("email"));
				paciente.setLogin(login);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao validar login\n " + e);
		}
		
		return paciente;
	}

	//Pesquisar paciente por id
	public Paciente pesquisar(Integer id) {
		Paciente paciente = null;
		sql = "select * from gs_paciente where paciente_id = ?";
		
		try(Connection connection = conexao.conectar()){
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				paciente = new Paciente();
				paciente.setId(id);
				paciente.setNome(rs.getString("paciente_nome"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setEmail(rs.getString("email"));
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao encontrar paciente\n " + e);
		}
		
		return paciente;
	}
	
	public List<Consulta> filtrar(Integer id) {
		//ta dando erro, depois arruma
		MedicoDAO dao = new MedicoDAO();
		List<Consulta> lista = new ArrayList<>();
		Consulta consulta = null;
		sql = "select * from gs_consulta where paciente_id = ? order by data_consulta ASC";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				consulta = new Consulta();
				Medico medico = new Medico();
				medico = dao.pesquisar(rs.getInt("medico_id"));
				Paciente paciente = new Paciente();
				paciente = pesquisar(id);
				
				consulta.setPaciente(paciente);
				consulta.setMedico(medico);
				java.sql.Timestamp timestamp = rs.getTimestamp("data_consulta");
				LocalDateTime data = timestamp.toLocalDateTime();
				consulta.setData(data);
				
				lista.add(consulta);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao listar medicos\n " + e);
		}
		return lista;
	}
	
	public List<Paciente> listar() {
		Paciente paciente = null;
		List<Paciente> lista = new ArrayList<>();
		sql = "SELECT paciente_id, paciente_nome, cpf from gs_paciente where login != 'admin'";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				paciente = new Paciente();
				paciente.setId(rs.getInt("paciente_id"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setNome(rs.getString("paciente_nome"));
				lista.add(paciente);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao listar pacientes\n " + e);
		}

		return lista;
	}
}
