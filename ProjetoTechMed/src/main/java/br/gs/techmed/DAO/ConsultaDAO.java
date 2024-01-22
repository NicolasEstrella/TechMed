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

public class ConsultaDAO extends DAO{

	public ConsultaDAO() {
		this.conexao = new Conexao();
	}

	//método para inserir consulta
	public void inserir(Consulta consulta) {

		sql = "insert into gs_consulta values(consulta_sequence.nextval, ?, ?, ?)";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, consulta.getPaciente().getId());
			ps.setInt(2, consulta.getMedico().getId());
			ps.setTimestamp(3, java.sql.Timestamp.valueOf(consulta.getData()));
			ps.execute();

			ps.close();
			connection.close();
		} catch (SQLException e) {
			System.out.println("erro ao inserir consulta\n " + e);
		}
	}

	//Método para listar todas as consultas do paciente
	public List<Consulta> relatorioPaciente(Integer id) {
		PacienteDAO dao1 = new PacienteDAO();
		MedicoDAO dao2 = new MedicoDAO();
		Consulta consulta = null;
		List<Consulta> lista = new ArrayList<>();
		sql = "select * from gs_consulta where paciente_id = ? order by data_consulta ASC";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				consulta = new Consulta();
				Paciente paciente = new Paciente();
				paciente = dao1.pesquisar(id);
				Medico medico = new Medico();
				
				medico = dao2.pesquisar(rs.getInt("medico_id"));
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
			System.out.println("erro ao listar relatório de pacientes\n " + e);
		}

		return lista;
	}

	public List<Consulta> pesquisar(Integer id, Integer id2) {
		PacienteDAO dao1 = new PacienteDAO();
		MedicoDAO dao2 = new MedicoDAO();
		Consulta consulta = null;
		List<Consulta> lista = new ArrayList<>();
		sql = "select * from gs_consulta where paciente_id = ? and medico_id = ? order by data_consulta ASC";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, id2);
			rs = ps.executeQuery();
			while (rs.next()) {
				consulta = new Consulta();
				Paciente paciente = new Paciente();
				paciente = dao1.pesquisar(id);
				Medico medico = new Medico();
				medico = dao2.pesquisar(id2);
	
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
			System.out.println("erro ao listar consultas\n " + e);
		}

		return lista;
	}
	
	//Método para listar todas as consultas do Médico
	public List<Consulta> relatorioMedico(Integer id) {
		PacienteDAO dao1 = new PacienteDAO();
		MedicoDAO dao2 = new MedicoDAO();
		Consulta consulta = null;
		List<Consulta> lista = new ArrayList<>();
		sql = "select * from gs_consulta where medico_id = ? order by data_consulta ASC";

		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				consulta = new Consulta();
				Paciente paciente = new Paciente();
				paciente = dao1.pesquisar(rs.getInt("paciente_id"));
				Medico medico = new Medico();
				medico = dao2.pesquisar(id);
				
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
			System.out.println("erro ao listar relatório de médicos\n " + e);
		}

		return lista;
	}
	
	public List<Consulta> relatorioGeral(){
		PacienteDAO dao1 = new PacienteDAO();
		MedicoDAO dao2 = new MedicoDAO();
		Consulta consulta = null;
		List<Consulta> lista = new ArrayList<>();
		
		sql = "select * from gs_consulta order by data_consulta ASC";
		
		try (Connection connection = conexao.conectar()) {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				consulta = new Consulta();
				Paciente paciente = new Paciente();
				paciente = dao1.pesquisar(rs.getInt("paciente_id"));
				Medico medico = new Medico();
				medico = dao2.pesquisar(rs.getInt("medico_id"));
				
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
			System.out.println("erro no relatório geral\n " + e);
		}
		
		return lista;
	}
}
