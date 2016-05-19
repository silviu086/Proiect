package chain.of.responsability;

public class CurierProfesionist extends Handler{

	private double greutateTotala;
	
	public CurierProfesionist(Comanda c) {
		super(c);
		greutateTotala = c.getGreutateTotala();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void livreaza() {
		// TODO Auto-generated method stub
		if(greutateTotala < 300){
			System.out.println("Comanda expediata prin curierat profesional!");
		}else{
			System.out.println("Comanda nu se poate expedia! Trebuie ridicata personal.");
		}
	}

}
