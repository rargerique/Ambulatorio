package br.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Paciente")
	@SequenceGenerator(name = "seq_Paciente", sequenceName = "s_Paciente", allocationSize = 1)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int idade;
	
	@Column(length = 50, nullable = true)
	private String telefoneContato;
	
	@Column(length = 50, nullable = true)
	private boolean doadorOrgaos;
	
	@Column(length = 50, nullable = true)
	private String tipoSanguineo;
	
	@OneToOne(mappedBy = "paciente", optional = true)
	private HistoricoMedico historicoMedico;
	
	public Paciente() {}
	
	public Paciente(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}

	public boolean isDoadorOrgaos() {
		return doadorOrgaos;
	}

	public void setDoadorOrgaos(boolean doadorOrgaos) {
		this.doadorOrgaos = doadorOrgaos;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public HistoricoMedico getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(HistoricoMedico historicoMedico) {
		this.historicoMedico = historicoMedico;
	}	

}
