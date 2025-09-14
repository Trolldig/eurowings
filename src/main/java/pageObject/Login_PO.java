package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Global_vars;

import java.time.Duration;

public class Login_PO extends Base_PO {
    private @FindBy(id = "onetrust-accept-btn-handler")
    WebElement accept_Button_Cookies;

    private @FindBy(id = "navigation-login-desktop")
    WebElement login_Icon_Desktop;

    private By login_Overlay = By.cssSelector(".o-layer__overlay");

    private @FindBy(name = "username")
    WebElement username_TextField;

    private @FindBy(name = "password")
    WebElement password_TextField;

    private @FindBy(xpath = "//span[@class='a-cta__text'][normalize-space()='Einloggen']")
    WebElement login_Button;

    private @FindBy(css = "p.o-notification__text--error")
    WebElement errorMessage;

    private @FindBy(className = "o-header-myew-submenu")
    WebElement navigationFlyout;

    public Login_PO() { super();}

    public void navigateTo_Homepage(){
        navigateTo_URL(Global_vars.EUROWINGS_HOMEPAGE_URL);
    }

    public void setUsername(String username) {
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password) {
        sendKeys(password_TextField, password);
    }

    public void clickOn_accept_Cookies_Button(){
        waitForWebElementAndClick(accept_Button_Cookies);
    }

    public void clickOn_Profile_Icon(){
        waitForWebElementAndClick(login_Icon_Desktop);
    }

    public void waitForOverlayToDisappear(){
        waitForWebElementToDisappear(login_Overlay);

    }

    public void clickOn_Login_Button(){
        waitForWebElementAndClick(login_Button);
    }

    public void waitForNavigationFlyout(){
        waitFor(navigationFlyout);
        Assert.assertTrue(navigationFlyout.isDisplayed());
    }

}
