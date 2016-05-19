package factory;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import builder.Produs;
import chain.of.responsability.Comanda;

public class DistribuitorIntermediar implements IDistribuitor {
	private String nume;
	private String IBAN;
	private ArrayList<Comanda> listaComenzi;
	
	public DistribuitorIntermediar(String nume, String iBAN) {
		super();
		this.nume = nume;
		IBAN = iBAN;
		listaComenzi = new ArrayList<>();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("Distribuitor intermediar cu numele " + this.nume + " avand IBAN=" + this.IBAN + ".Contine " + listaComenzi.size() + " comenzi!");
		
	}

	@Override
	public void addComanda(Comanda c) {
		// TODO Auto-generated method stub
		listaComenzi.add(c);
	}

	@Override
	public ArrayList<Comanda> getListaComenzi() {
		// TODO Auto-generated method stub
		return listaComenzi;
	}

	@Override
	public int importComenziFromFile(File file) {
		// TODO Auto-generated method stub
		int nrComenzi = 0;
		try{
			if(file.exists()){
				Scanner scan = new Scanner(file);
				if(scan.hasNextLine()){
					while(scan.hasNextLine()){
						String[] elemente;
						Comanda c = new Comanda();
						int nr = scan.nextInt();
						scan.nextLine();
						for(int i=0;i<nr;i++){
							elemente = scan.nextLine().split(" ");
							String nume = elemente[0];
							double pret = Double.valueOf(elemente[1]);
							Produs p = new Produs(nume, pret);
							c.adaugaProdus(p);
						}
						nrComenzi++;
						listaComenzi.add(c);
				}
			}else{
				nrComenzi = -1;
			}
		}else{
			nrComenzi = -2;
		}
		}catch(Exception ex){
			
		}
		return nrComenzi;
	}
	
	
}
