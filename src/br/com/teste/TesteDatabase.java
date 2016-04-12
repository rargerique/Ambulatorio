package br.com.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.model.Paciente;

public class TesteDatabase {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(new Paciente("Eduardo"));
		em.getTransaction().commit();
		
		System.out.println("Paciente: " + em.find(Paciente.class, 1L).getNome());

	}

}
