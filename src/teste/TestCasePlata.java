package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import adapter.Adapter;
import adapter.PaymentBCR;
import adapter.PaymentBRD;
import strategy.IPlata;
import strategy.Plata;
import strategy.PlataCard;
import strategy.PlataOrdin;

public class TestCasePlata {

	@Test
	public void test_getSold() {
		Plata plata = new Plata(1);
		double expected = -1;
		assertEquals(expected, plata.getSold(), 0.1);
	}
	
	@Test
	public void test_getSold2(){
		Plata plata = new Plata(2);
		PaymentBCR payment = new PaymentBCR("card1234", "12.12.12", 345);
		IPlata metodaPlata = new PlataCard(payment);
		plata.setMetodaPlata(metodaPlata);
		assertEquals(345, plata.getSold(), 0.1);
	}
	
	@Test
	public void test_setMetodaPlata(){
		IPlata metodaPlata = null;
		try{
			Plata plata = new Plata(3);
			plata.setMetodaPlata(metodaPlata);
			fail("Nu trebuie sa ajunga aici");
		}catch(NullPointerException ex){
			
		}
	}
	
	@Test
	public void test_setMetodaPlata2(){
		PaymentBCR payment = new PaymentBCR("bcr1234", "14.06.2015", 345);
		IPlata metodaPlata = new PlataOrdin(payment);
		Plata plata = new Plata(4);
		plata.setMetodaPlata(metodaPlata);
		plata.plateste(45);
		assertEquals(300, plata.getSold(), 0.1);
	}
	
	@Test
	public void test_plateste(){
		Plata plata = new Plata(5);
		try{
			plata.plateste(100);
			fail("Nu trebuie sa ajunga aici!");
		}catch(UnsupportedOperationException ex){
			
		}
	}
	
	@Test 
	public void test_plateste2(){
		Plata plata = new Plata(6);
		IPlata metodaPlata = new PlataCard(new PaymentBCR("bcr1234", "12.12.2015", 50));
		plata.setMetodaPlata(metodaPlata);
		assertFalse(plata.plateste(60));
	}
	
	@Test
	public void test_plateste3(){
		Plata plata = new Plata(7);
		PaymentBCR payment = new PaymentBCR("bcr134" ,"12.05.2016", 100);
		IPlata metodaPlata = new PlataOrdin(payment);
		plata.setMetodaPlata(metodaPlata);
		assertTrue(plata.plateste(99.5));
	}
	
	@Test
	public void test_plateste4(){
		try{
			Plata plata = new Plata(8);
			PaymentBCR payment = null;
			IPlata metodaPlata = new PlataCard(payment);
			plata.setMetodaPlata(metodaPlata);
			plata.plateste(22.3);
			fail("Nu trebuie sa ajunga aici!");
		}catch(NullPointerException ex){
		}
	}
	
	

}
