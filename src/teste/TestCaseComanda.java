package teste;

import static org.junit.Assert.*;

import org.junit.Test;

import builder.Produs;
import builder.ProdusBuilder;
import chain.of.responsability.Comanda;

public class TestCaseComanda {

	@Test
	public void test_Comanda(){
		Comanda c = new Comanda();
		assertNotNull(c.getLista());
	}
	
	@Test
	public void test_Comanda2(){
		Comanda c = new Comanda();
		assertEquals(0, c.getGreutateTotala(), 0.1);
	}
	
	@Test
	public void test_Comanda3(){
		Comanda c = new Comanda();
		ProdusBuilder builder = new ProdusBuilder("Prod1", 222);
		Produs p = builder.setDimensiune("12x34x56")
				.setGreutate(78).build();
		c.adaugaProdus(p);
		assertEquals(78, c.getGreutateTotala(), 0.1);
	}
	
	@Test
	public void test_Comanda4(){
		Comanda c = new Comanda();
		ProdusBuilder builder = new ProdusBuilder("Prod1", 124);
		Produs p = builder.setGreutate(34).build();
		c.adaugaProdus(p);
		p = builder.setNume("Prod2").setGreutate(15).build();
		c.adaugaProdus(p);
		assertEquals(49, c.getGreutateTotala(), 0.1);
	}
	
	@Test
	public void test_Comanda5(){
		Comanda c = new Comanda();
		ProdusBuilder builder = new ProdusBuilder("Prod1", 234);
		Produs p = builder.setGreutate(123).build();
		c.adaugaProdus(p);
		assertEquals(1, c.getLista().size());
	}

}
