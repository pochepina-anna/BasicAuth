package io.aerobatic;

import io.aerobatic.helpers.DriverSetUp;
import io.aerobatic.pages.AerobaticAuthPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


/**
 * Класс <class>BasicAuthTest</class>
 */
public class BasicAuthTest extends DriverSetUp {

    private static final String URL = RunningAllSuiteTest.getUrl();
    private AerobaticAuthPage aerobaticAuthPage = new AerobaticAuthPage(driver);

    @Test
    public void basicAuth()throws Exception {
        openAerobaticAuthPage(driver,URL);
        basicAerobaticAuth();
    }

    private void openAerobaticAuthPage(WebDriver driver, String url) {
        driver.get(url);
    }

    private void basicAerobaticAuth() throws InterruptedException {
        aerobaticAuthPage.standartAuthButtonClick();
        Assert.assertTrue("LogIn is Failed",aerobaticAuthPage.logOutButtonIsVisible());
    }
}
