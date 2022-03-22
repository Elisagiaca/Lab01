package it.polito.tdp.parole.model;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
	LinkedList<String> listaParole;
	
	public Parole() {
		//TODO
		listaParole = new LinkedList<>();
	}
	
	public void addParola(String p) {
		//TODO
		listaParole.add(p);
	}
	
	public List<String> getElenco() {
		//TODO
		Collections.sort(listaParole, new ComparatoreAlfabetico());
		return listaParole;
	}
	
	public void reset() {
		// TODO
		listaParole.clear();
	}

	public void eliminaParola(String s) {
		int indice = listaParole.indexOf(s);
		listaParole.remove(indice);
	}
}
