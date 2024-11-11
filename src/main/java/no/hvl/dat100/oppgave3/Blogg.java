package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;


public class Blogg {

	// TODO: objektvariable 
	private Innlegg[] innleggtabell;
	private int nesteledig = 0;


	public Blogg() {
		this.innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		
	}

	public int getAntall() {
		return  nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int pos = -1;
		for (int i = 0; i < innleggtabell.length; i++) {
			if (innleggtabell[i] != null && innleggtabell[i].getId() == innlegg.getId()) {
				pos = i;
				break; // Avslutter med en gang vi finner innlegget
			}
		}
		return pos;
	
	}

		public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
            for (Innlegg innleggtabell1 : innleggtabell) {
                if (innleggtabell1 != null && innleggtabell1.getId() == innlegg.getId()) {
                    finnes = true;
                    break; // Avslutter med en gang søket er fullført
                }
            }
		return finnes;
	}
	

		public boolean ledigPlass() {
		 
			return nesteledig < innleggtabell.length; // Hvis nesteledig er større enn antall objekter i listen vil dette være true 
	}

	
	
	public boolean leggTil(Innlegg innlegg) {

		boolean leggtil = false;
		if (ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			leggtil = true;
		}		
		return leggtil;
	}
	
	public String toString() {
		String s = nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			s += innleggtabell[i].toString();
		}
		return s;
	}
	


	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}