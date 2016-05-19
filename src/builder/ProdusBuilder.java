package builder;

public class ProdusBuilder implements IBuilder{
	private Produs produs;
	
	public ProdusBuilder(String nume, double pret){
		this.produs = new Produs(nume, pret);
	}
	
	public ProdusBuilder setNume(String nume){
		produs.setNume(nume);
		return this;
	}
	
	public ProdusBuilder setGreutate(double greutate){
		this.produs.setGreutate(greutate);
		return this;
	}
	
	public ProdusBuilder setDimensiune(String dimensiune){
		this.produs.setDimnesiune(dimensiune);
		return this;
	}

	@Override
	public Produs build() {
		// TODO Auto-generated method stub
		return produs;
	}	
}
