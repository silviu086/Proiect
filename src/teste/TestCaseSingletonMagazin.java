package teste;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import builder.Produs;
import factory.DistribuitorIntermediar;
import factory.FactoryDistribuitor;
import factory.IDistribuitor;
import factory.TipDistribuitor;
import singleton.SingletonMagazin;

public class TestCaseSingletonMagazin {

	static SingletonMagazin magazin;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		magazin = SingletonMagazin.getInstance();
	}
	
	
	@Test
	public void test_SingletonMagazin(){
		
		assertNotNull(magazin);
	}
	
	@Test 
	public void test_SingletonMagazin2(){
		SingletonMagazin magazin = SingletonMagazin.getInstance();
		SingletonMagazin magazin2 = SingletonMagazin.getInstance();
		assertSame(magazin, magazin2);
		
	}
	
	@Test
	public void test_SingletonMagazin3(){
		SingletonMagazin.reset(1234);
		SingletonMagazin magazin = SingletonMagazin.getInstance();
		assertNull(magazin.getNume());
		assertNull(magazin.getAdresa());
		assertNull(magazin.getTelefon());
		assertNotNull(magazin.getListaDistribuitori());
		assertNotNull(magazin.getListaProduse());
	}
	
	@Test
	public void test_SingletonMagazin4(){
		magazin.setAdresa("Strada Lamotesti, Nr.10");
		assertEquals("Strada Lamotesti, Nr.10", magazin.getAdresa());
	}
	
	@Test 
	public void test_SingletonMagazin5(){
		magazin.setNume("Magazin");
		magazin.setTelefon("0766222111");
		assertEquals("Magazin", magazin.getNume());
		assertEquals("0766222111", magazin.getTelefon());
	}
	
	@Test
	public void test_SingletonMagazin6(){
		assertNotNull(magazin.getAdresa());
		assertNotNull(magazin.getNume());
		assertNotNull(magazin.getTelefon());
	}
	
	@Test
	public void test_SingletonMagazin7(){
		Produs p = new Produs("Produs1", 123);
		magazin.addProdus(p);
		assertEquals(1, magazin.getListaProduse().size());
	}
	
	@Test
	public void test_SingletonMagazin8(){
		IDistribuitor distribuitor = new FactoryDistribuitor().createObject("Distribuitor1", "IBAN12512421", TipDistribuitor.INTERMEDIAR);
		magazin.addDistribuitor(distribuitor);
		assertEquals(1, magazin.getListaDistribuitori().size());
	}
	
	@Test
	public void test_SingletonMagazin9() throws Exception{
		File file = new File("produse.txt");
		int nr = magazin.importProduseFromFile(file);
		assertEquals(2, nr);
	}
	
	@Test
	public void test_SingletonMagazin10(){
		File file = new File("produse2.txt");
		int nr = magazin.importProduseFromFile(file);
		assertEquals(-1, nr);
	}
	
	@Test
	public void test_SingletonMagazin11(){
		File file = new File("produse3.txt");
		int nr = magazin.importProduseFromFile(file);
		assertEquals(-2, nr);
	}
	
	@Test
	public void test_SingletonMagazinCautaDistribuitor(){
		IDistribuitor distri = magazin.cautaDistribuitor("Distri1");
		assertNull(distri);
	}
	
	@Test
	public void test_SingletonMagazinCautaDistribuitor2(){
		IDistribuitor distribuitor = 
				new DistribuitorIntermediar("Distribuitor1", "IBAN1234");
		magazin.addDistribuitor(distribuitor);
		IDistribuitor distriCautat = magazin.cautaDistribuitor("Distribuitor1");
		assertNotNull(distriCautat);
	}
}
