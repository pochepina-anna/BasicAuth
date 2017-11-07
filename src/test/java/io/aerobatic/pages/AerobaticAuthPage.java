package io.aerobatic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс <class>AerobaticAuthPage</class>
 */
public class AerobaticAuthPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='examples']//a[contains(text(),'Standard auth')]")
    private WebElement standartAuthButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logOutButton;


    public AerobaticAuthPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void standartAuthButtonClick(){
        wait.until(ExpectedConditions.elementToBeClickable(standartAuthButton)).click();
    }

    public boolean logOutButtonIsVisible(){
        return wait.until(ExpectedConditions.elementToBeClickable(logOutButton)).isDisplayed();
    }
}


