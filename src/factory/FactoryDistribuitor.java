package factory;

public class FactoryDistribuitor {
	IDistribuitor distribuitor;
	public IDistribuitor createObject(String nume, String IBAN, TipDistribuitor tip){
		switch(tip){
		case PROPRIU:
			distribuitor = new DistribuitorPropriu(nume, IBAN);
			break;
		case INTERMEDIAR:
			distribuitor = new DistribuitorIntermediar(nume, IBAN);
			break;
		default:
			throw new UnsupportedOperationException("Tip distribuitor necunoscut!");
		}
	return distribuitor;
	}
}
