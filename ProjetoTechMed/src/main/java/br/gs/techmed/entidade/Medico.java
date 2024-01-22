package br.gs.techmed.entidade;

public class Medico {
	private Integer id;
	private String crm;
	private String nome;
	private String especialidade;
	private Double valorConsulta;
	
	public Double getValorConsulta() {
		return valorConsulta;
	}
	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
