package ninzaCRM.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener{
	ExtentTest test ;
	ExtentReports report;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ------TestExectionStarted---------");
		
		//Intimate extent report for @testStart
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ------TestExectionPass---------");
		
		//Log the status of @test as PASS in extent report
		test.log(Status.PASS, methodName+" ------TestExectionPass---------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//capture the ScreenShot
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wb = new WebDriverUtility();
		String ScreenShotName = methodName+ju.getStringDate();
		try {
			String path = wb.captureScreenShot(BaseClass.sdriver, ScreenShotName);
			//Attach screenShot to report
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Log the status of @test as Failed in extent report
		test.log(Status.FAIL, methodName+" ------TestExectionFailed---------");
		System.out.println(methodName+" ------TestExectionStartedFailed---------");
		
		
		//Log the Exception of @test as Failed in extent report
		test.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ------TestExectionSkiped---------");
		//Log the Skipped of @test as Failed in extent report
		test.log(Status.SKIP, methodName+" ------TestExectionSkiped---------");
		
		//Log the Exception of @test as Failed in extent report
		test.log(Status.INFO, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("------SuiteExectionStarted---------");
		//extend report Configuration
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReport\\ExtentReport"+new JavaUtility().getStringDate()+".html");
		esr.config().setDocumentTitle("Ninza CRM Automation Report");
		esr.config().setTheme(Theme.STANDARD);
		esr.config().setReportName("Automation Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Brower", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base URL", "Test Env");
		report.setSystemInfo("Reporter NAme", "Saiteja");
		}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("------SuiteExectionStarted---------");
		report.flush();
	}

}
