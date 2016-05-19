package adapter;

public class Adapter implements IPaymentBCR{

	private IPaymentBRD paymentBRD;
		
	public Adapter(IPaymentBRD paymentBRD) {
		super();
		this.paymentBRD = paymentBRD;
	}

	@Override
	public boolean platesteOrdin(double pret) {
		// TODO Auto-generated method stub
		return paymentBRD.payOrdin(pret);
	}

	@Override
	public boolean platesteCard(double pret) {
		// TODO Auto-generated method stub
		return paymentBRD.payCard(pret);
	}

}
