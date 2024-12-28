package urBuddi.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest {

	@Test
	public void mainTest1() {
		System.out.println("Main Test1");
	}
	
	@Test
	public void mainTest2() {
		System.out.println("Main Test2");
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("I am in after Main Test");
	}
	
	@BeforeTest
	public void test() {
		System.out.println("I am in before Main Test");
		
	}
	

}
