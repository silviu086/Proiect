package adapter;

public class PaymentBCR implements IPaymentBCR{

	private String cardNumber;
	private String dataExpirare;
	private double sold;
	
	public PaymentBCR(String cardNumber, String dataExpirare, double sold) {
		super();
		this.cardNumber = cardNumber;
		this.dataExpirare = dataExpirare;
		this.sold = sold;
	}

	public double getSold(){
		return this.sold;
	}
	
	@Override
	public boolean platesteOrdin(double pret) {
		// TODO Auto-generated method stub
		if(sold > pret){
			System.out.println("Se plateste prin ordin de plata cu cardul BCR " + cardNumber + ".Suma retrasa este de " + pret);
			sold -= pret;
			return true;
		}else{
			System.out.println("Nu se poate platii.");
			return false;
		}
	}

	@Override
	public boolean platesteCard(double pret) {
		// TODO Auto-generated method stub
		if(sold > pret){
			System.out.println("Se plateste cu cardul BCR " + cardNumber + ".Suna retrasa este de "+ pret);
			sold -= pret;
			return true;
		}else{
			System.out.println("Nu se poate platii. Sold insuficient!");
			return false;
		}
	}

}
