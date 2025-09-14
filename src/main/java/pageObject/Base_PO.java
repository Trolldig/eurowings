package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_vars;
import java.time.Duration;

public class Base_PO {

    public Base_PO(){
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver(){
        return drivers.DriverFactory.getDriver();
    }

    public void navigateTo_URL(String url){
        getDriver().get(url);
    }

    public void waitFor(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForWebElementAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForWebElementToDisappear(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }
}
