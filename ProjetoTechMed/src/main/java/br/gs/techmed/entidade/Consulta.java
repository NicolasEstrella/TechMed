package br.gs.techmed.entidade;

import java.time.LocalDateTime;

import br.gs.techmed.util.Util;

public class Consulta {
	private Integer id;
	private LocalDateTime data;
	private Paciente paciente;
	private Medico medico;
	
	public String jaConsultado() {
		LocalDateTime agora = LocalDateTime.now();
		if (data.isAfter(agora)) {
			return "Não realizada";
		}
		return "Já realizada";
	}
	
	public String getFormatData() {
		Util util = new Util();
		return util.formatarData(data);
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}



	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
}
