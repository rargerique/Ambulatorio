package br.com.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class HistoricoMedico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_HistMedico")
	@SequenceGenerator(name = "seq_HistMedico", sequenceName = "s_HistMedico", allocationSize = 1)
	private Long id;
	
	@OneToMany(mappedBy="historicoMedico")
    public Collection<Doenca> doencas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Doenca> getDoencas() {
		return doencas;
	}

	public void setDoencas(Collection<Doenca> doencas) {
		this.doencas = doencas;
	}

	@Override
	public String toString() {
		return "HistoricoMedico [doencas=" + doencas + "]";
	}	

}
