package it.leg.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainDiProva {

	public static void main(String[] args) throws ParseException {
		// Creo l'entity manager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("legClinic");
		EntityManager em = emf.createEntityManager();

//		 Creo le date che mi serviranno
		String prenotazioneString = "23/02/1995 at 13:03:12";
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss"); 
				
		Date prenotazione = df1.parse(prenotazioneString);
		
		String visitaString = "23/02/2006 at 12:45:33";
		DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy 'at' HH:mm:ss");
		Date visita = df2.parse(visitaString);
		
		long secs1 = prenotazione.getTime();
		Date prenotazione1 = new java.sql.Date(secs1);
		
		long secs2 = visita.getTime();
		Date visita1 = new java.sql.Date(secs2);	
		
		// Creo gli oggetti
		Medico medico = new Medico("Pancrazio", "Cingoletti", "culologia");
		Paziente paziente = new Paziente("Giancula", "Gonte", "glucacont@gg.it", "bamboo");
		TipologiaEsame tipologia = new TipologiaEsame("culo", "culoh", 3.5F);
		Esame esame = new Esame(tipologia, paziente, medico);
		
		// Collego i vari oggetti come richiesto
		paziente.aggiungiEsame(esame);
		medico.aggiungiEsame(esame);
		esame.setDataPrenotazione(prenotazione1);
		esame.setDataSvolgimento(visita1);
		
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
