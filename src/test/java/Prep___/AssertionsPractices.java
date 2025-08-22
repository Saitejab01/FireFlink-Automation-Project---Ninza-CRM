package Prep___;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractices {
//	@Test
//	public void sampleTest() {
//		System.out.println("step 1");
//		System.out.println("step 2");
//		Assert.assertEquals(1, 2);
//		System.out.println("step 3");
//		System.out.println("step 4");
//		Assert.assertEquals("a", "b");
//		System.out.println("step 5");
//	}
	@Test
	public void sampleTest() {
		System.out.println("step 1");
		System.out.println("step 2");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(1, 2);
		System.out.println("step 3");
		System.out.println("step 4");
		sa.assertEquals("b", 2);
		System.out.println("step 5");
		sa.assertAll();
	}

}
