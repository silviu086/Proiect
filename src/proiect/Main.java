package proiect;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import adapter.Adapter;
import adapter.PaymentBCR;
import adapter.PaymentBRD;
import builder.Produs;
import builder.ProdusBuilder;
import chain.of.responsability.Comanda;
import chain.of.responsability.CurierProfesionist;
import chain.of.responsability.CurierPropriu;
import chain.of.responsability.Handler;
import decorator.Biscuite;
import decorator.BiscuiteCiocolata;
import factory.FactoryDistribuitor;
import factory.IDistribuitor;
import factory.TipDistribuitor;
import singleton.SingletonMagazin;
import strategy.IPlata;
import strategy.Plata;
import strategy.PlataOrdin;
import teste.TestSuite1;
import teste.TestSuiteAll;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Boolean exit = false;
		int comanda;
		Scanner scan = new Scanner(System.in);
		SingletonMagazin magazin = null;
		
		while(!exit){
			System.out.println("\n Menu");
			System.out.println("-----");
			System.out.println("1. Initializare magazin [Singleton]");
			System.out.println("2. Adauga distribuitor [Factory]");
			System.out.println("3. Importa comenzi pentru un distribuitor");
			System.out.println("4. Adauga produs [Builder]");
			System.out.println("5. Import produse din produse.txt");
			System.out.println("6. Afisare distribuitori");
			System.out.println("7. Afisare produse");
			System.out.println("8. Plateste [Adapter]");
			System.out.println("9. Afisare biscuite [Decorator]");
			System.out.println("10. Comanda produs [Facade]");
			System.out.println("11. Plata [Strategy]");
			System.out.println("12. Expediere comanda [Chain of responsability]");
			System.out.println("13. Run TestSuite1");
			System.out.println("14. Run TestSuiteAll");
			System.out.println("15. Exit");
			System.out.print("\n Comanda: ");
			comanda = scan.nextInt();
			
			switch(comanda){
			case 1:
				System.out.println("Initializare magazin...");
				magazin = SingletonMagazin.getInstance();
				System.out.println("Magazin initializat!");
					
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 2:
				String nume = null;
				String IBAN = null;
				if(magazin!=null){
					int tip;
					TipDistribuitor tipD = null;
					FactoryDistribuitor factory = new FactoryDistribuitor();
					System.out.print("Nume=");
					scan.nextLine();//skip line from nextInt
					nume = scan.nextLine();
					System.out.print("IBAN=");
					IBAN = scan.nextLine();
					System.out.print("Tip: 1(Propriu)/0 (Intermediar): ");
					tip = scan.nextInt();
					if(tip == 1){
						tipD = TipDistribuitor.PROPRIU;
					}else if(tip == 0){
						tipD = TipDistribuitor.INTERMEDIAR;
					}
					IDistribuitor distribuitor = factory.createObject(nume, IBAN, tipD);
					magazin.addDistribuitor(distribuitor);
					System.out.println("Distribuitorul " + nume + " a fost adaugat la magazin!");
					
				}else{
					System.out.println("Trebuie sa initializati magazinul!");
				}
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 3:
				String numeDistribuitor;
				if(magazin!=null){
					System.out.print("Numele distriubitorului: ");
					scan.nextLine();
					numeDistribuitor = scan.nextLine();
					IDistribuitor d = magazin.cautaDistribuitor(numeDistribuitor);
					if(d != null){
						File file = new File("comenzi.txt");
						int nr = d.importComenziFromFile(file);
						System.out.println("S-au adaugat " + nr + "comenzi!");
					}else{
						System.out.println("Nu exista distribuitorul " + numeDistribuitor);
					}
				}else{
					System.out.println("Trebuie sa initiliazati magazinul!");
				}
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 4:
				String numeProdus;
				double pretProdus;
				double greutateProdus;
				String dimensiuneProdus;
				if(magazin!=null){
					System.out.print("Nume produs: ");
					scan.nextLine();
					numeProdus = scan.nextLine();
					System.out.print("Pret produs: ");
					pretProdus = scan.nextDouble();
					System.out.println("Produs creat!");
					System.out.print("Adaugati detalii despre produs?(1/0) raspuns: ");
					comanda = scan.nextInt();
					if(comanda == 1){
						System.out.print("Greutate produs: ");
						greutateProdus = scan.nextDouble();
						System.out.print("Dimensiune produs: ");
						scan.nextLine();
						dimensiuneProdus = scan.nextLine();
						ProdusBuilder builder = new ProdusBuilder(numeProdus, pretProdus);
						Produs produs = builder.setDimensiune(dimensiuneProdus)
								.setGreutate(greutateProdus).build();
						magazin.addProdus(produs);
						System.out.println("Produsul a fost adaugat!");
					}else{
						Produs produs = new Produs(numeProdus, pretProdus);
						magazin.addProdus(produs);
						System.out.println("Produsul a fost adaugat!");
					}
					
				}else{
					System.out.println("Trebuie sa initializati magazinul!");
				}
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 5:
				if(magazin!=null){
					File file = new File("produse.txt");
					int nr = magazin.importProduseFromFile(file);
					System.out.println("Produse adaugate: " + nr);
				}else{
					System.out.println("Trebuie sa initiliazati magazinul!");
				}
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 6:
				if(magazin!=null){
					ArrayList<IDistribuitor> listaDistribuitori;
					listaDistribuitori = magazin.getListaDistribuitori();
					for(IDistribuitor i : listaDistribuitori){
						i.info();
					}
				}else{
					System.out.println("Trebuie sa initializati magazinul!");
				}
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 7:
				if(magazin!=null){
					ArrayList<Produs> listaProduse;
					listaProduse = magazin.getListaProduse();
					for(Produs p : listaProduse){
						if(p.getDimnesiune()!=null){
							System.out.println("Produs: " + p.getNume() + ", Pret: " + p.getPret() + ", Greutate: " + p.getGreutate() + ", Dimensiune: " + p.getDimnesiune());
						}else{
							System.out.println("Produs: " + p.getNume() + ", Pret: " + p.getPret());
						}
					}
				}else{
					System.out.println("Trebuie sa initializati magazinul!");
				}
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 8:
				String cardNumber;
				String dataExpirare;
				double sumaPlatita;
				System.out.println("Adaugare card BRD");
				System.out.print("Card number: ");
				scan.nextLine();
				cardNumber = scan.nextLine();
				System.out.print("Data expirare: ");
				dataExpirare = scan.nextLine();
				System.out.println("Card BRD creat!");
				System.out.print("Suma de plata: ");
				sumaPlatita = scan.nextDouble();
				System.out.println("Se face plata prin BCR");
				Adapter adapter = new Adapter(new PaymentBRD(cardNumber, dataExpirare, 200.0));
				adapter.platesteCard(sumaPlatita);
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 9:
				Biscuite biscuiteSimplu = new Biscuite("Biscuite simplu", 5, "apa, faina, zahar");
				BiscuiteCiocolata biscuiteCiocolata = new BiscuiteCiocolata(biscuiteSimplu);
				biscuiteCiocolata.setIngredienteNoi("ciocolata");
				System.out.println("Biscuite normal: " + biscuiteSimplu.getIngrediente());
				System.out.println("Biscuite ciocolata: " + biscuiteCiocolata.getIngrediente());
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 10:
				scan.nextLine();
				System.out.print("Nume produs: ");
				numeProdus = scan.nextLine();
				System.out.print("Pret produs: ");
				pretProdus = scan.nextDouble();
				scan.nextLine();
				System.out.print("Card number: ");
				cardNumber = scan.nextLine();
				System.out.print("Data expirare: ");
				dataExpirare = scan.nextLine();
				Facade.Facade.comandaProdus(numeProdus, pretProdus, cardNumber, dataExpirare);
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 11:
				PaymentBCR payment = new PaymentBCR("card1234", "01.05.2014", 125.0);
				IPlata metodaPlata = new PlataOrdin(payment);
				Plata plata = new Plata(1);
				plata.setMetodaPlata(metodaPlata);
				plata.plateste(40.5);
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 12:
				Comanda comandaProduse = new Comanda();
				
				Produs p1 = new Produs("Prod1", 45.78);
				p1.setGreutate(70);
				comandaProduse.adaugaProdus(p1);
				Handler curierPropriu = new CurierPropriu(comandaProduse);
				Handler curierPro = new CurierProfesionist(comandaProduse);
				curierPropriu.setOpUrmatoare(curierPro);
				curierPropriu.livreaza();
				
				Produs p2 = new Produs("Prod2", 70.4);
				p2.setGreutate(305.5);
				comandaProduse.adaugaProdus(p2);
				curierPropriu = new CurierPropriu(comandaProduse);
				curierPro = new CurierProfesionist(comandaProduse);
				curierPropriu.setOpUrmatoare(curierPro);
				curierPropriu.livreaza();
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 13:
				Result result = JUnitCore.runClasses(TestSuite1.class);
				for(Failure i : result.getFailures()){
					System.out.println(i.getMessage());
				}
				
				System.out.println("Success: " + result.wasSuccessful());
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 14:
				Result result2 = JUnitCore.runClasses(TestSuiteAll.class);
				for(Failure i : result2.getFailures()){
					System.out.println(i.getMessage());
				}
				
				System.out.println("Success: " + result2.wasSuccessful());
				
				//back to menu
				System.out.print("\nReveniti la meniu?(1/0) raspuns: ");
				comanda = scan.nextInt();
				if(comanda == 0){
					exit=true;
				}
				break;
			case 15:
				scan.close();
				System.exit(0);
				break;
			}
		}
	}

}
