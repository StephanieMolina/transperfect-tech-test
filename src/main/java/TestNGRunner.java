import org.testng.TestNG;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TestNGRunner {

    public static void main(String[] _args) throws InvocationTargetException {
        /**
         * create object of TestNG
         */
        TestNG obj = new TestNG();
        /**
         * Define List
         */
        List<String> suites = new ArrayList<String>();
        /**
         * add TestNG xml files
         */
        suites.add("./multiple.xml");
        /**
         * set suites to run
         */
        obj.setTestSuites(suites);
        /**
         * run method
         */
        obj.run();
    }
}
