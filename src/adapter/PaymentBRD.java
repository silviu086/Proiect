package adapter;

public class PaymentBRD implements IPaymentBRD{
	private String cardNumber;
	private String dataExperareCard;
	private double sold;
	
	public PaymentBRD(String cardNumber, String dataExperareCard, double sold) {
		super();
		this.cardNumber = cardNumber;
		this.dataExperareCard = dataExperareCard;
		this.sold = sold;
	}

	public double getSold(){
		return this.sold;
	}
	
	@Override
	public boolean payOrdin(double pret) {
		// TODO Auto-generated method stub
		if(sold > pret){
			System.out.println("Se plateste prin ordin de plata de pe cardul BRD " + cardNumber + ".Valoarea retrasa este de " + pret);
			sold -= pret;
			return true;
		}else{
			System.out.println("Nu se poate platii!Sold insuficient! ");
			return false;
		}

	}

	@Override
	public boolean payCard(double pret) {
		// TODO Auto-generated method stub
		if(sold > pret){
			System.out.println("Se plateste cu cardul BRD " + cardNumber + ".Valoarea retrasa este de " + pret);
			sold -= pret;
			return true;
		}else{
			System.out.println("Nu se poate platii! Sold insuficient!");
			return false;
		}
	}
}
