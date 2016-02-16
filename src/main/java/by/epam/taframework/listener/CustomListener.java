package by.epam.taframework.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

/**
 * Created by Yahor_Faliazhynski on 2/4/2016.
 */
public class CustomListener implements IInvokedMethodListener {

        @Override
        public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
            System.out.println("method started: " + method.getTestMethod().getMethodName());
        }

        @Override
        public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
            System.out.println("method finished [" + testResult.getStatus() + "]:" + method.getTestMethod().getMethodName() + "\n");
        }

}

