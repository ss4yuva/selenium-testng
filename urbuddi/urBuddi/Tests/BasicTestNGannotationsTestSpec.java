package urBuddi.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Common.BaseMethods;

public class BasicTestNGannotationsTestSpec extends BaseMethods {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am in Before Suite");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am in Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("I am in Before Method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am in Before Test");
	}

	@Test
	public void test() {
		System.out.println("I am in Test");
	}

	@Test
	public void secondTest() {
		System.out.println("I am in second Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am in After Test");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am in After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am in After Class");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am in After Suite");
	}

}
