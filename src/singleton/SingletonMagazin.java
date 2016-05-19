package singleton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import builder.Produs;
import builder.ProdusBuilder;
import factory.IDistribuitor;
import sun.java2d.pipe.OutlineTextRenderer;

public class SingletonMagazin {
	private static SingletonMagazin instance = null;
	
	public static SingletonMagazin getInstance(){
		if(instance == null){
			instance = new SingletonMagazin();
		}
		return instance;
	}
	
	private String nume;
	private String adresa;
	private String telefon;
	private ArrayList<IDistribuitor> listaDistributori;
	private ArrayList<Produs> listaProduse;
	
	private SingletonMagazin(){
		listaDistributori = new ArrayList<>();
		listaProduse = new ArrayList<>();
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public ArrayList<IDistribuitor> getListaDistribuitori(){
		return this.listaDistributori;
	}
	
	public void addDistribuitor(IDistribuitor distribuitor){
		this.listaDistributori.add(distribuitor);
	}
	
	public ArrayList<Produs> getListaProduse(){
		return this.listaProduse;
	}
	
	public void addProdus(Produs produs){
		this.listaProduse.add(produs);
	}
	
	public int importProduseFromFile(File file){
		int nrProduse = 0;
		try{
			if(file.exists()){
				Scanner scan = new Scanner(file);
				String[] elemente;
				if(scan.hasNextLine()){
					while(scan.hasNextLine()){
						elemente = scan.nextLine().split(" ");
						String nume = elemente[0];
						double pret = Double.parseDouble(elemente[1]);
						double greutate = Double.parseDouble(elemente[2]);
						String dimensiune = elemente[3];
						Produs p = new ProdusBuilder(nume, pret)
								.setGreutate(greutate)
								.setDimensiune(dimensiune)
								.build();
						listaProduse.add(p);
						nrProduse++;
					}
					scan.close();
				}
			}else{
				nrProduse = -2;
			}
			if(nrProduse == 0){
				nrProduse = -1;
			}
		}catch(Exception ex){
			
		}
		return nrProduse;
	}
	
	public IDistribuitor cautaDistribuitor(String nume){
		IDistribuitor distribuitor = null;
		for(IDistribuitor i : listaDistributori){
			if(i.getNume().equals(nume)){
				distribuitor = i;
			}
		}
		return distribuitor;
	}
	
	public static void reset(int key){
		if(key == 1234){
			instance = new SingletonMagazin();
		}
	}
}
