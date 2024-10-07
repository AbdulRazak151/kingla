package abdul01.SeleniumFrameworkDesign.stepdefinations;
import org.testng.Assert;
import abdul01.SeleniumFrameworkDesign.TestComponents.BaseTest;
import abdul01.SeleniumFrameworkDesign.pageobjects.CartPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.CheckoutPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.ConfirmationPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.LandingPage;
import abdul01.SeleniumFrameworkDesign.pageobjects.ProductCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//https://www.way2automation.com/create-feature-file-and-step-definition-file-in-cucumber/
public class StepDefinationimpl extends BaseTest {
public LandingPage landingpage;
public ProductCatalogue productcatelog;
public CartPage cartpage;
public ConfirmationPage confirmation;

@Given("I landed on Ecommerce Page")
public void I_landed_on_Ecommerce_Page() throws Exception {
landingpage=launchApplication();
}
@Given("^Loginned in with username (.+) and password (.+)$")
public void lognned_in_username_and_password(String userName,String password) {
productcatelog=landingpage.loginApplication(userName,password);
}
@When ("^i add product (.+) to Cart$")
public void i_add_product_to_cart(String productName) throws Exception {
productcatelog.getProductList();
productcatelog.addProducttoCart(productName);
Thread.sleep(3000);
}
@When("^Checkout (.+) and submit the order$")
public void Checkout_submit_Order(String productName) throws Exception {
cartpage=productcatelog.gotoCartPage();
boolean match = cartpage.match(productName);
Assert.assertTrue(match);
Thread.sleep(5000);
CheckoutPage checkoutpage=cartpage.gotoCheckout();
checkoutpage.selectCountry("india");
confirmation=checkoutpage.submitOrder();
Thread.sleep(5000);
}
@Then("{string} message is displayed on Confirmation Page")
public void message_is_displayed_confirmation_page(String string) {
String verifyConfirmationMessage = confirmation.verifyConfirmationMessage();
Assert.assertTrue(verifyConfirmationMessage.equalsIgnoreCase(string));


}
@Then("^\"([^\"]*)\" message is displayed$")
public void something_message_is_displayed(String strArg1) throws Throwable {

	Assert.assertEquals(strArg1, landingpage.getErrorMessage());
	driver.close();
}

}
