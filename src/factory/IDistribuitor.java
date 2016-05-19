package factory;

import java.io.File;
import java.util.ArrayList;

import chain.of.responsability.Comanda;

public interface IDistribuitor {
	public void info();
	public String getNume();
	public void addComanda(Comanda c);
	public ArrayList<Comanda> getListaComenzi();
	public int importComenziFromFile(File file);
}
