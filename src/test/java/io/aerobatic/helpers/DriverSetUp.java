package io.aerobatic.helpers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Класс <class>DriverSetUp</class>
 */
public class DriverSetUp {

    public static WebDriver driver;
    public static BrowserMobProxyServer server;


    @BeforeClass
    public static void setUp() throws Exception{
        ChromeDriverManager.getInstance().setup();
        server = new BrowserMobProxyServer();
        server.autoBasicAuthorization("auth-demo.aerobatic.io", "aerobatic", "aerobatic");
        server.start();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--proxy-server=localhost:"
                + server.getPort());
        driver = new ChromeDriver(option);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        server.stop();
    }
}
