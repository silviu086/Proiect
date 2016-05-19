package builder;

public class Produs {
	private String nume;
	private double pret;
	private double greutate;
	private String dimnesiune;
	
	public Produs(String nume, double pret) {
		super();
		this.nume = nume;
		this.pret = pret;
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}

	public double getGreutate() {
		return greutate;
	}

	public void setGreutate(double greutate) {
		this.greutate = greutate;
	}

	public String getDimnesiune() {
		return dimnesiune;
	}

	public void setDimnesiune(String dimnesiune) {
		this.dimnesiune = dimnesiune;
	}
	
	
	
}
