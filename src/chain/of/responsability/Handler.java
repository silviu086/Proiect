package chain.of.responsability;

public abstract class Handler {
	protected Handler opUrmatoare;
	protected Comanda comanda;
	
	public Handler(Comanda c){
		this.comanda = c;
	}
	
	public void setOpUrmatoare(Handler opUrm){
		this.opUrmatoare = opUrm;
	}
	
	public abstract void livreaza();
}
