package Facade;

import adapter.IPaymentBCR;
import adapter.PaymentBCR;
import builder.Produs;
import singleton.SingletonMagazin;

public class Facade {
	
	public static void comandaProdus(String numeProdus, double pretProdus, String cardNumber, String dataExpirare) {
		Produs produs = new Produs(numeProdus, pretProdus);
		PaymentBCR card = new PaymentBCR(cardNumber, dataExpirare, 300.0);
		System.out.println("Produsul " + numeProdus + " comandat la furnizor.");
		SingletonMagazin magazin = SingletonMagazin.getInstance();
		magazin.addProdus(produs);
		System.out.println("Produsul " + numeProdus + " adaugat in magazin.");
		IPaymentBCR payment = new PaymentBCR(cardNumber, dataExpirare, 300.0);
		payment.platesteCard(produs.getPret());
		System.out.println("Produs expediat!");
	}
	
	
}
