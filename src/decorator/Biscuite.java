package decorator;

import builder.Produs;

public class Biscuite extends Produs implements IBiscuite{

	private String ingrediente;
	
	public Biscuite(String nume, double pret, String ingrediente) {
		super(nume, pret);
		this.ingrediente = ingrediente;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getIngrediente() {
		// TODO Auto-generated method stub
		return this.ingrediente;
	}
}
