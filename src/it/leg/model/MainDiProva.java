package it.leg.model;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainDiProva {

	public static void main(String[] args) {
		// Creo l'entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("legClinic");
		EntityManager em = emf.createEntityManager();

		// Creo le date che mi serviranno
		Date prenotazione = new Date(25-12-1995);
		Date visita = new Date(12-02-2002);
		
		// Creo gli oggetti
		Medico medico = new Medico("Pancrazio", "Cingoletti", "culologia");
		Paziente paziente = new Paziente("Giancula", "Gonte", "glucacont@gg.it", "bamboo");
		TipologiaEsame tipologia = new TipologiaEsame("culo", "culoh", 3.5F);
		Esame esame = new Esame(tipologia, paziente, medico);
		
		// Collego i vari oggetti come richiesto
		paziente.aggiungiEsame(esame);
		medico.aggiungiEsame(esame);
		esame.setDataPrenotazione(prenotazione);
		esame.setDataSvolgimento(visita);
		
		// Uso l'entity manager per ottenere la persistenza e creare le tabelle nel database
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(medico);
		em.persist(paziente);
		em.persist(tipologia);
		em.persist(esame);

		tx.commit();

		em.close();
		emf.close();
	}
}
