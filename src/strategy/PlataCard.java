package strategy;

import adapter.PaymentBCR;

public class PlataCard implements IPlata{

	private PaymentBCR payment;
	
	
	
	public PlataCard(PaymentBCR payment) {
		super();
		this.payment = payment;
	}



	@Override
	public boolean plateste(double pret) {
		// TODO Auto-generated method stub
		return payment.platesteCard(pret);
	}



	@Override
	public double getSold() {
		// TODO Auto-generated method stub
		return payment.getSold();
	}

}
