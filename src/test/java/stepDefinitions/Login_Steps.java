package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObject.Base_PO;
import pageObject.Login_PO;

public class Login_Steps extends Base_PO {

    private Login_PO loginPO;

    public Login_Steps(){
        this.loginPO = new Login_PO();
    }

    @Given("I access the homepage")
    public void i_access_the_homepage() {
        loginPO.navigateTo_Homepage();
    }

    @Then("I should be presented with the user profile page")
    public void i_should_be_presented_with_the_user_profile_page(){}
}
