package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assertions_02 {

	@Test

	public void test1(){

		SoftAssert sa= new SoftAssert();

		sa.assertTrue(1<2);

		System.out.println("Assertion Pass");

		sa.assertFalse(2<1);

		System.out.println("Assertion Pass");

		sa.assertEquals("Sample", "Sample");

		System.out.println("Assertion Pass");
		
		sa.assertAll();
	}
}
