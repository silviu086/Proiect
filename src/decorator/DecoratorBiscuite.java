package decorator;

public abstract class DecoratorBiscuite implements IBiscuite{
	protected Biscuite biscuite;

	public DecoratorBiscuite(Biscuite biscuite) {
		super();
		this.biscuite = biscuite;
	}

	@Override
	public String getIngrediente() {
		// TODO Auto-generated method stub
		return biscuite.getIngrediente();
	}
}
