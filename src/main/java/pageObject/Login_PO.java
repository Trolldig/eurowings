package pageObject;

import utils.Global_vars;

public class Login_PO extends Base_PO {

    public Login_PO() { super();}

    public void navigateTo_Homepage(){
        navigateTo_URL(Global_vars.EUROWINGS_HOMEPAGE_URL);
    }
}
