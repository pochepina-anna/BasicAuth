package io.aerobatic;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Класс <class>RunningAllSuiteTest</class>
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BasicAuthTest.class
})
public class RunningAllSuiteTest {

    private static final String URL = "https://auth-demo.aerobatic.io/";

    public static String getUrl() {
        return URL;
    }

}
