package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCaseComanda.class, TestCaseDistribuitor.class, TestCasePayment.class, TestCasePlata.class,
		TestCaseSingletonMagazin.class, TestSuite1.class })
public class TestSuiteAll {

}
