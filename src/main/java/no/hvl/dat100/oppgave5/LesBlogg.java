package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		File file = new File(mappe, filnavn);
		Blogg blogg = null;


		try (BufferedReader leser = new BufferedReader(new FileReader(file))) {
			
			// Leser første linje (antall innlegg)
			int antall = Integer.parseInt(leser.readLine());
			blogg = new Blogg(antall);

			// Leser linjene videre 
			for (int i = 0; i < antall; i++) {				
				String type = leser.readLine();
				int id = Integer.parseInt(leser.readLine());
				String bruker = leser.readLine();
				String dato = leser.readLine();
				int likes = Integer.parseInt(leser.readLine());
				String tekst = leser.readLine();

				Innlegg innlegg = null;

				//Sjekker hvilke type innlegg det er snakk om og leser videre
				if (type.equals(TEKST)) {
					innlegg = new Tekst(id, bruker, dato, likes, tekst);
				} else if (type.equals(BILDE)) {
					String url = leser.readLine();
					innlegg = new Bilde(id, bruker, dato, likes, tekst, url);
				}

				//Legger til den ekstra linjen utifra hvilke type det er snakk om
				blogg.leggTil(innlegg);
				
			}

		//Hvis filen ikke finnes 	
		} catch (IOException e) {
			return null;
			
		}

		return blogg;

		
		

	}
}
