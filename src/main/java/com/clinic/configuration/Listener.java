package com.clinic.configuration;


import com.clinic.report.AllureManager;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    public void onStart(ISuite arg0) {
        Reporter.log("About to begin executing Suite " + arg0.getName(), true);
    }

    public void onFinish(ISuite arg0) {
        Reporter.log("About to end executing Suite " + arg0.getName(), true);
    }

    public void onStart(ITestContext arg0) {
        Reporter.log("About to begin executing Test " + arg0.getName(), true);
    }

    public void onFinish(ITestContext arg0) {
        Reporter.log("Completed executing test " + arg0.getName(), true);
    }

    public void onTestSuccess(ITestResult arg0) {
        printTestResults(arg0);
    }

    public void onTestFailure(ITestResult arg0) {
        printTestResults(arg0);
        AllureManager.saveTextLog(arg0.getName() + " is failed.");
        AllureManager.saveScreenshotPNG();
    }

    public void onTestStart(ITestResult arg0) {
        System.out.println("The execution of the main test starts now");
    }

    public void onTestSkipped(ITestResult arg0) {
        printTestResults(arg0);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    private void printTestResults(ITestResult result) {
        Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
        if (result.getParameters().length != 0) {
            String params = null;

            for (Object parameter : result.getParameters()) {

                params += parameter.toString() + ",";
            }
            Reporter.log("Test Method had the following parameters : " + params, true);
        }
        String status = null;
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                status = "Pass";
                break;

            case ITestResult.FAILURE:

                status = "Failed";

                break;

            case ITestResult.SKIP:

                status = "Skipped";

        }

        Reporter.log("Test Status: " + status, true);

    }

    // This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test

    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());

        Reporter.log(textMsg, true);

    }

    // This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test

    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());

        Reporter.log(textMsg, true);

    }

    // This will return method names to the calling function

    private String returnMethodName(ITestNGMethod method) {

        return method.getRealClass().getSimpleName() + "." + method.getMethodName();

    }


}
