package br.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

public class Internacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Internacao")
	@SequenceGenerator(name = "seq_HistMedico", sequenceName = "s_HistMedico", allocationSize = 1)
	private Long id;
	
	@Column(length = 50, nullable = true)
	private String nome;	
	
	@ManyToOne
    public HistoricoMedico historicoMedico;

}
