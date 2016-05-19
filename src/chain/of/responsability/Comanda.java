package chain.of.responsability;

import java.util.ArrayList;

import builder.Produs;
import strategy.Plata;

public class Comanda {
	private ArrayList<Produs> lista;
	private double greutateTotala;
	private double pretTotal;
	private Plata plata;
	
	public Comanda(){
		lista = new ArrayList<>();
		greutateTotala = 0;
		pretTotal = 0;
	}
	
	public void adaugaProdus(Produs p){
		lista.add(p);
		pretTotal += p.getPret();
		greutateTotala += p.getGreutate();
	}
	
	public boolean plateste(){
		if(plata!=null){
			return plata.plateste(pretTotal);
		}
		return false;
	}
	
	public void setPlata(Plata p){
		this.plata = p;
	}
	
	public double getGreutateTotala(){
		return greutateTotala;
	}
	
	public ArrayList<Produs> getLista(){
		return this.lista;
	}
}
