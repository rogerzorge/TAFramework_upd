package by.epam.emailtest.runner;

import by.epam.taframework.listener.CustomListener;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yahor_Faliazhynski on 2/4/2016.
 */
public class CustomRunner {

    public static void main(String[] args) throws Exception{
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG tng = new TestNG();
        tng.addListener(tla);
        tng.addListener(new CustomListener());

        XmlSuite suite = new XmlSuite();
        suite.setName("TempSuite");

        List<String> filesSuite = new ArrayList<>();
        filesSuite.add("./src/test/resources/suites/CustomSuite.xml");
        suite.setSuiteFiles(filesSuite);
//        suite.setParallel(XmlSuite.ParallelMode.METHODS);
//        suite.setThreadCount(4);

        List<XmlSuite> suites = new ArrayList<>();
        suites.add(suite);
        tng.setXmlSuites(suites);

        tng.run();
    }

}
