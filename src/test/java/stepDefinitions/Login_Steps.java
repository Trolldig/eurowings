package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageObject.Base_PO;
import pageObject.Login_PO;
import utils.Credentials;

public class Login_Steps extends Base_PO {

    WebDriver driver;
    private Login_PO loginPO;
    private String user;

    public Login_Steps(Login_PO login_po){
        this.loginPO = login_po;
    }

    @Before
    public void setup(){
        driver = getDriver();
    }

    @Given("I access the homepage")
    public void i_access_the_homepage() {
        loginPO.navigateTo_Homepage();
    }

    @And("I accept cookies")
    public void i_accept_cookies(){
        loginPO.clickOn_accept_Cookies_Button();
    }

    @And("I click on the profile icon")
    public void i_click_on_the_profile_icon(){
        loginPO.waitForOverlayToDisappear();
        loginPO.clickOn_Profile_Icon();
    }

    @And("I enter a username")
    public void i_enter_a_username() {
        loginPO.setUsername(Credentials.user());
    }

    @And("I enter a password")
    public void i_enter_a_password() {
        loginPO.setPassword(Credentials.password());
    }

    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPO.clickOn_Login_Button();
    }

    @Then("I should be presented with the flyout meta navigation")
    public void i_should_be_presented_with_the_flyout_meta_navigation(){
        loginPO.waitForNavigationFlyout();
    }
}
