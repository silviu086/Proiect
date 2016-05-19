package decorator;

public class BiscuiteCiocolata extends DecoratorBiscuite {

	private String ingredienteNoi;
	
	public BiscuiteCiocolata(Biscuite biscuite) {
		super(biscuite);
		// TODO Auto-generated constructor stub
	}
	

	public String getIngredienteNoi() {
		return ingredienteNoi;
	}



	public void setIngredienteNoi(String ingredienteNoi) {
		this.ingredienteNoi = ingredienteNoi;
	}



	@Override
	public String getIngrediente() {
		// TODO Auto-generated method stub
		return super.getIngrediente() + ", " + ingredienteNoi;
	}

	
}
