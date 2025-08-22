package Prep___;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelperAttributesInTestNGTest {
	//normal @test
	
	
//	@Test
//	public void create() {
//		System.out.println("create");
//	}
//	@Test
//	public void modify() {
//		System.out.println("modify");
//	}
//	@Test
//	public void delete() {
//		System.out.println("delete");
//	}
	
	
//	@Test(priority = int)
	
//	@Test(priority = -1)
//	public void create() {
//		System.out.println("create");
//	}
//	@Test(priority = -2)
//	public void modify() {
//		System.out.println("modify");
//	}
//	@Test(priority = -3)
//	public void delete() {
//		System.out.println("delete");
//	}
	
//	@Test(invocationCount = int)
	
//	@Test(invocationCount = 2)
//	public void create() {
//		System.out.println("create");
//	}
//	@Test(priority = -2)
//	public void modify() {
//		System.out.println("modify");
//	}
//	@Test(priority = -3)
//	public void delete() {
//		System.out.println("delete");
//	}
	
	
//	@Test(enabled = boolean)
//	@Test(enabled = false)
//	public void create() {
//		System.out.println("create");
//	}
//	@Test(priority = -2)
//	public void modify() {
//		System.out.println("modify");
//	}
//	@Test(priority = -3)
//	public void delete() {
//		System.out.println("delete");
//	}
	
	@Test
	public void create() {
		Assert.fail();
		System.out.println("create");
	}
	@Test(dependsOnMethods = {"create"})
	public void modify() {
		System.out.println("modify");
	}
	@Test(dependsOnMethods = {"create","modify"})
	public void delete() {
		System.out.println("delete");
	}
}
