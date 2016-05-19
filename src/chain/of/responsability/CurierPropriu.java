package chain.of.responsability;

public class CurierPropriu extends Handler{

	private double greutateTotala;
	
	public CurierPropriu(Comanda c) {
		super(c);
		greutateTotala = c.getGreutateTotala();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void livreaza() {
		// TODO Auto-generated method stub
		if(greutateTotala < 100){
			System.out.println("Comanda expediata prin curierat propriu!");
		}else{
			opUrmatoare.livreaza();
		}
	}

}
