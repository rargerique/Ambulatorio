package br.com.teste;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.model.Doenca;
import br.com.model.HistoricoMedico;
import br.com.model.Internacao;
import br.com.model.Medico;
import br.com.model.Paciente;
import br.com.model.Quarto;

public class TesteDatabase {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();
		
		//Adicionando doenças
		em.getTransaction().begin();
		
		Doenca rinite = new Doenca();
		rinite.setNome("Rinite");
		em.persist(rinite);
		
		Doenca pressaoAlta = new Doenca();
		pressaoAlta.setNome("Pressão Alta");
		em.persist(pressaoAlta);
		
		Doenca asma = new Doenca();
		asma.setNome("Asma");
		em.persist(asma);
		
		em.getTransaction().commit();
		
		TypedQuery<Doenca> queryDoenca = em.createQuery("SELECT d FROM Doenca d", Doenca.class);
		System.out.println("Doenças:");
		for (Doenca doenca : queryDoenca.getResultList()) {
			System.out.println(doenca.getNome());
		}		
		
		//Adicionando quartos
		em.getTransaction().begin();
		
		Quarto quarto1 = new Quarto();
		quarto1.setNumero("100");
		em.persist(quarto1);
		
		Quarto quarto2 = new Quarto();
		quarto2.setNumero("101");
		em.persist(quarto2);
		
		Quarto quarto3 = new Quarto();
		quarto3.setNumero("102");
		em.persist(quarto3);
		
		em.getTransaction().commit();
		
		TypedQuery<Quarto> queryQuarto = em.createQuery("SELECT q FROM Quarto q", Quarto.class);
		System.out.println("Quartos:");
		for (Quarto quarto : queryQuarto.getResultList()) {
			System.out.println(quarto.getNumero());
		}	
		
		//Adicionando médicos
		em.getTransaction().begin();
		
		Medico joao = new Medico();
		joao.setNome("Joao");
		em.persist(joao);

		Medico maria = new Medico();
		maria.setNome("Maria");
		em.persist(maria);
		
		Medico janeDoe = new Medico();
		janeDoe.setNome("Jane Doe");
		em.persist(janeDoe);
		
		em.getTransaction().commit();
		
		TypedQuery<Medico> queryMedico = em.createQuery("SELECT m FROM Medico m", Medico.class);
		System.out.println("Medicos:");
		for (Medico medico : queryMedico.getResultList()) {
			System.out.println(medico.getNome());
		}	
		
		//Adicionando paciente
		em.getTransaction().begin();
		
		Paciente p = new Paciente();
		p.setDoadorOrgaos(true);
		p.setIdade(66);
		p.setNome("Eduardo");
		p.setTelefoneContato("55-51-6666-6666");
		p.setTipoSanguineo("B-");
		
		//Adicionando Historico Medico
		HistoricoMedico historicoMedico = new HistoricoMedico();
		
		Collection<Doenca> doencas = new ArrayList<Doenca>();
		doencas.add(rinite);
		doencas.add(pressaoAlta);
		doencas.add(asma);
		
		historicoMedico.setDoencas(doencas);
		p.setHistoricoMedico(historicoMedico);
		
		//Adicionando internação
		Internacao internacao = new Internacao();
		internacao.setMedico(maria);
		internacao.setQuarto(quarto1);
		
		Collection<Internacao> internacoes = new ArrayList<Internacao>();
		internacoes.add(internacao);
		p.setInternacao(internacoes);
		
		em.persist(internacao);
		em.persist(historicoMedico);
		em.persist(p);
		
		em.getTransaction().commit();
		
		TypedQuery<Paciente> queryPaciente = em.createQuery("SELECT p FROM Paciente p", Paciente.class);
		System.out.println("Paciente:");
		for (Paciente paciente : queryPaciente.getResultList()) {
			System.out.println(paciente.toString());
		}	
		
		System.exit(0);	

	}

}
