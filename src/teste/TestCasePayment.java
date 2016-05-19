package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import adapter.PaymentBCR;
import adapter.PaymentBRD;

public class TestCasePayment {

	@Test
	public void test_PaymentBCR(){
		PaymentBCR payment = new PaymentBCR("1241241", "12.12.2016", 100);
		assertEquals(100, payment.getSold(), 0.1);
	}
	
	@Test
	public void test_PaymentBRD(){
		PaymentBRD payment = new PaymentBRD("532532", "12.02.2016", 200);
		assertEquals(200, payment.getSold(), 0.1);
	}
	
	@Test
	public void test_PaymentBCR2(){
		PaymentBCR payment = new PaymentBCR("532532", "02.05.2016", 50);
		assertTrue(payment.platesteCard(45));
		assertFalse(payment.platesteCard(10));
	}
	
	@Test
	public void test_PaymentBCR3(){
		PaymentBCR payment = new PaymentBCR("412512", "02.07.2016", 60);
		payment.platesteCard(30);
		assertEquals(30, payment.getSold(), 0.1);
	}
	
	@Test
	public void test_PaymentBRD2(){
		PaymentBRD payment = new PaymentBRD("421512", "06.02.2016", 40);
		assertTrue(payment.payCard(30));
		assertFalse(payment.payOrdin(20));
	}
	
	@Test
	public void test_PaymentBRD3(){
		PaymentBRD payment = new PaymentBRD("412512", "16.05.2016", 80);
		payment.payOrdin(40);
		assertEquals(40, payment.getSold(), 0.1);
	}
	
	

}
