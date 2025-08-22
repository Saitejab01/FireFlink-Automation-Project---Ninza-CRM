package Prep___;

import org.testng.annotations.Test;

public class ReadDataFromCMDLine {
	@Test
	public void readData() {
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		String UN = System.getProperty("un");
		System.out.println(UN);
		String PASS = System.getProperty("pass");
		System.out.println(PASS);
	}
}
