package teste;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import builder.Produs;
import chain.of.responsability.Comanda;
import factory.DistribuitorIntermediar;
import factory.DistribuitorPropriu;
import factory.FactoryDistribuitor;
import factory.IDistribuitor;
import factory.TipDistribuitor;

public class TestCaseDistribuitor {

	@Test
	public void test_DistribuitorIntermediar(){
		DistribuitorIntermediar distribuitor = new DistribuitorIntermediar("Distr1", "IBAN1234");
		assertEquals("Distr1", distribuitor.getNume());
		assertEquals("IBAN1234", distribuitor.getIBAN());
	}
	
	@Test
	public void test_DistribuitorIntermediar2(){
		DistribuitorIntermediar distribuitor = 
				new DistribuitorIntermediar("Distr2", "IBAN1234");
		distribuitor.setNume("Distr3");
		distribuitor.setIBAN("IBAN3456");
		assertEquals("Distr3", distribuitor.getNume());
		assertEquals("IBAN3456", distribuitor.getIBAN());
	}
	
	@Test 
	public void test_DistribuitorIntermediar3(){
		DistribuitorIntermediar distribuitor = 
				new DistribuitorIntermediar("Distr3", "IBAN1234");
		assertNotNull(distribuitor.getListaComenzi());
	}
	
	@Test
	public void test_DistribuitorIntermediar4(){
		DistribuitorIntermediar distribuitor = 
				new DistribuitorIntermediar("Distr4", "IBAN1234");
		Comanda c = new Comanda();
		c.adaugaProdus(new Produs("Prod1", 1234));
		distribuitor.addComanda(c);
		assertEquals(1, distribuitor.getListaComenzi().size());
	}
	
	@Test
	public void test_DistribuitorPropriu(){
		DistribuitorPropriu distribuitor = 
				new DistribuitorPropriu("DistribuitorPropriu1", "IBAN1234");
		assertEquals("DistribuitorPropriu1", distribuitor.getNume());
		assertEquals("IBAN1234", distribuitor.getIBAN());
	}
	
	@Test
	public void test_DistribuitorPropriu2(){
		DistribuitorPropriu distribuitor = 
				new DistribuitorPropriu("DistribuitorPropriu2", "IBAN1234");
		distribuitor.setIBAN("IBAN2222");
		distribuitor.setNume("DistribuitorPropriuNou");
		assertEquals("DistribuitorPropriuNou", distribuitor.getNume());
		assertEquals("IBAN2222", distribuitor.getIBAN());
	}
	
	@Test
	public void test_DistribuitorPropriu3(){
		DistribuitorPropriu distribuitor = 
				new DistribuitorPropriu("DistribuitorPropriu3", "IBAN1234");
		assertNotNull(distribuitor.getListaComenzi());
	}
	
	@Test
	public void test_DistribuitorPropriu4(){
		DistribuitorPropriu distribuitor = 
				new DistribuitorPropriu("DistribuitorPropriu4" ,"IBAN1234");
		Comanda c = new Comanda();
		c.adaugaProdus(new Produs("Prod1", 1244));
		distribuitor.addComanda(c);
		assertEquals(1, distribuitor.getListaComenzi().size());
	}
	
	@Test
	public void test_DistribuitorFactory(){
		FactoryDistribuitor factory = new FactoryDistribuitor();
		IDistribuitor distribuitor = 
				factory.createObject("Distri1", "IBAN1234", TipDistribuitor.INTERMEDIAR);
		assertNotNull(distribuitor);
		assertEquals("Distri1", distribuitor.getNume());
	}
	
	@Test
	public void test_DistribuitorFactory2(){
		try{
			FactoryDistribuitor factory = new FactoryDistribuitor();
			IDistribuitor distribuitor = 
					factory.createObject("Distribuitor", "IBAN1234", TipDistribuitor.STRAIN);
			fail("Nu trebuie sa ajunga aici!");
		}catch(Exception ex){
			
		}
	}
	
	@Test
	public void test_DistribuitorIntermediarImport(){
		DistribuitorIntermediar distribuitor = 
				new DistribuitorIntermediar("Distri1", "IBAN1234");
		File file = new File("comenzi.txt");
		int nr = distribuitor.importComenziFromFile(file);
		assertEquals(2, distribuitor.getListaComenzi().size());
	}
	
	@Test
	public void test_DistribuitorIntermediarImport2(){
		DistribuitorIntermediar distribuitor = 
				new DistribuitorIntermediar("Distri2", "IBAN1234");
		File file = new File("comenzi2.txt");
		int nr = distribuitor.importComenziFromFile(file);
		assertEquals(-1, nr);
	}
	
	@Test
	public void test_DistribuitorIntermediarImport3(){
		DistribuitorIntermediar distribuitor = 
				new DistribuitorIntermediar("Distri3", "IBAN1234");
		File file = new File("comenzi3.txt");
		int nr = distribuitor.importComenziFromFile(file);
		assertEquals(-2, nr);
	}
	
	@Test
	public void test_DistribuitorPropriuImport(){
		DistribuitorPropriu distribuitor = 
				new DistribuitorPropriu("Distri1", "IBAN1234");
		File file = new File("comenzi.txt");
		int nr = distribuitor.importComenziFromFile(file);
		assertEquals(2, nr);
	}
	
	@Test
	public void test_DistribuitorPropriuImport2(){
		DistribuitorPropriu distribuitor = 
				new DistribuitorPropriu("Distri2", "IBAN1234");
		File file = new File("comenzi2.txt");
		int nr = distribuitor.importComenziFromFile(file);
		assertEquals(-1, nr);
	}
	
	@Test
	public void test_DistribuitorPropriuImport3(){
		DistribuitorPropriu distribuitor = 
				new DistribuitorPropriu("Distri3", "IBAN1234");
		File file = new File("comenzi3.txt");
		int nr = distribuitor.importComenziFromFile(file);
		assertEquals(-2, nr);
	}

}
