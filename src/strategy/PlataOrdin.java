package strategy;

import adapter.PaymentBCR;

public class PlataOrdin implements IPlata{

	private PaymentBCR payment;
	
	
	
	public PlataOrdin(PaymentBCR payment) {
		super();
		this.payment = payment;
	}



	@Override
	public boolean plateste(double pret) {
		// TODO Auto-generated method stub
		return payment.platesteOrdin(pret);
	}



	@Override
	public double getSold() {
		// TODO Auto-generated method stub
		return payment.getSold();
	}

}
