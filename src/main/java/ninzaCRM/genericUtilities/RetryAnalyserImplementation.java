package ninzaCRM.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{
	int count =0 ;
	int retrycount = 4; // manual analysis
	@Override
	public boolean retry(ITestResult result) { //it will run when the Test Script is FAIL
		while (count<retrycount) {
			count++;
			return true; // retry
		}
		return false; // Stop retry
	}

}
