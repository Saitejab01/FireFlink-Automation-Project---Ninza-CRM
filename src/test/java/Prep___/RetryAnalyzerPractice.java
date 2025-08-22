package Prep___;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryAnalyzerPractice {
	@Test(retryAnalyzer = ninzaCRM.genericUtilities.RetryAnalyserImplementation.class)
	public void sample() {
		Assert.fail();
		System.out.println("try");
	}
}
