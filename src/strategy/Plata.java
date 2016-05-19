package strategy;

public class Plata {
	private int nrPlata;
	private IPlata metodaPlata;
	
	public Plata(int nr){
		this.nrPlata = nr;
	}
	
	public double getSold(){
		if(metodaPlata!=null){
			return metodaPlata.getSold();
		}
		return -1;
	}
	
	public void setMetodaPlata(IPlata plata){
		if(plata != null){
			System.out.println("Setare metodata de plata pentru plata " + nrPlata);
			this.metodaPlata = plata;
		}else{
			throw new NullPointerException("Metoda plata este null");
		}
	}
	
	public boolean plateste(double pret){
		boolean result = false;
		if(metodaPlata!=null){
			result = metodaPlata.plateste(pret);
		}else{
			System.out.println("Setati metodata de plata!");
			throw new UnsupportedOperationException("Setare metoda plata");
		}
		return result;
	}
}
