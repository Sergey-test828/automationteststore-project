package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import support.TestContext;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class AutoTestStoreStepDefs {
    Home homePage = new Home();
    AccountLogin accountLogin = new AccountLogin();
    Menu menuPage = new Menu();
    MyAccount myAccountPage = new MyAccount();
    ProductsMenu productsMenuPage = new ProductsMenu();
    ProductDetails productDetailsPage = new ProductDetails();
    ShoppingCart shoppingCartPage = new ShoppingCart();
    ProductCategory productCategoryPage = new ProductCategory();
    CheckoutConfirmation checkoutConfirmationPage = new CheckoutConfirmation();
    DeliveryInformation deliveryInformationPage = new DeliveryInformation();
    ShippingAddress shippingAddressPage = new ShippingAddress();

    @Given("I go to automationteststore page")
    public void iGoToAutomationteststorePage() {
        homePage.open();
    }
    @Given("I mouse over {string} and click to {string} and verify subProduct name")
    public void iMouseOverAndClickToAndVerifysubProductName(String productCategory, String subCategory) {
        menuPage.mouseOverCategoryMenu(productCategory);
        menuPage.clickSubCategory(subCategory);
        assertThat(productsMenuPage.getProductName()).isEqualToIgnoringCase(subCategory);
    }
    @Given("I click button Change Address")
    public void iClickButtonChangeAddress() {
        deliveryInformationPage.clickChangeAddress();
    }
    @When("I click Login or register")
    public void iClickLoginOrRegister() {
        menuPage.clickLoginOrRegisterButton();
    }
    @When("I log in as {string}")
    public void iLogInAs(String customer) {
        Map<String, String> user = TestContext.getDataByFileName(customer);
        menuPage.clickLoginButton();
        accountLogin.logIn(user.get("loginName"), user.get("password"));
    }
    @When("I click to {string} product and put Qty {int}")
    public void iClickToProductAndPutQty(String product, Integer quantity) {
        productsMenuPage.clickProductTitle(product);
        productDetailsPage.emptyingQuantity();
        productDetailsPage.sendKeysToQuantity(String.valueOf(quantity));
    }
    @When("I click to {string} product and put size {string}")
    public void iClickToProductAndPutSize(String product, String size) {
        productsMenuPage.clickProductTitle(product);
        productDetailsPage.sendKeysToSize(size);
    }
    @When("I verify FRAGRANCE subproduct page open and I click Women category")
    public void iVerifyFRAGRANCESubproductPageOpenAndIClickWomenCategory() {
        assertThat(productCategoryPage.getSubCategoryName()).isEqualToIgnoringCase("FRAGRANCE");
        productCategoryPage.clickWomenCategory();
    }
    @Then("I verify sign in as first name {string}")
    public void iVerifySignInAsFirstName(String firstName) {
        assertThat(myAccountPage.getMyAccountName()).isEqualToIgnoringCase(firstName);
    }
    @And("I remove all items from shopping cart")
    public void iRemoveAllItemsFromShoppingCart() {
        menuPage.clickShoppingCat();
        shoppingCartPage.clickRemoveItem();
    }
    @Then("I verify {string} in product details and click Add to cart")
    public void iVerifyInProductDetailsAndClickAddToCart(String product) {
        assertThat(productDetailsPage.getProductName()).isEqualToIgnoringCase(product);
        productDetailsPage.clickAddToCart();
    }
    @And("I verify {string} as product name display in cart")
    public void iVerifyAsProductNameInCartDisplayInCart(String productName) {
        assertThat(shoppingCartPage.getShoppingCartProductName()).contains(productName);
    }
    @Then("I click to continue shopping")
    public void iClickToContinueShopping() {
        shoppingCartPage.clickContinueShopping();
    }
    @Given("I click to FRAGRANCE menu button")
    public void iClickToFRAGRANCEMenuButton() {
        menuPage.clickFragrance();
    }
    @And("I verify WOMEN category page open and I click Beauty Eau de Parfum product")
    public void iVerifyWOMENCategoryPageOpenAndIClickBeautyEauDeParfumProduct() {
        assertThat(productCategoryPage.getWomenCategoryName()).isEqualToIgnoringCase("WOMEN");
        productCategoryPage.clickBeautyEayParfum();
    }
    @And("I verify Beauty Eau de Parfum in product details and I click Add to cart")
    public void iVerifyBeautyEauDeParfumInProductDetailsAndIClickAddToCart() {
        assertThat(productDetailsPage.getBeautyEayParfum()).isEqualToIgnoringCase("Beauty Eau de Parfum");
        productDetailsPage.clickAddToCart();
    }
    @Then("I verify Beauty Eau de Parfum in table and I click Checkout")
    public void iVerifyBeautyEauDeParfumInTableAndIClickCheckout() {
        shoppingCartPage.clickCheckout();
    }
    @When("I verify ORDER SUMMARY contains Beauty Eau de Parfum and click to confirm order")
    public void iVerifyORDERSUMMARYContainsBeautyEauDeParfumAndClickToConfirmOrder() {
        assertThat(checkoutConfirmationPage.getOrderSummary()).isEqualToIgnoringCase("Beauty Eau de Parfum");
        checkoutConfirmationPage.clickConfirmOrder();
    }
    @When("I verify percent of taxes for {string} and click checkout")
    public void iVerifyPercentOfTaxesForAndClickCheckOut(String name) {
        Map<String, String> user = TestContext.getDataByFileName(name);
        assertThat(user.get("taxes")).isEqualTo(shoppingCartPage.getStateTaxes());
        System.out.println(">>>>>>>Retail taxes: " + shoppingCartPage.getStateTaxes());
        shoppingCartPage.clickCheckout();
    }
    @When("I set {string} shipping address and click continue")
    public void iSetShippingAddressAndClickContinue(String receiver) {
        Map<String, String> receiverName = TestContext.getDataByFileName(receiver);
        shippingAddressPage.shippingAddressFields(receiverName);
        shippingAddressPage.clickContinueRefresh();
    }
    @And("I verify checkout success and click continue")
    public void iVerifyCheckoutSuccessAndClickContinue() {
        assertThat(checkoutConfirmationPage.getCheckoutSuccess()).isEqualTo("YOUR ORDER HAS BEEN PROCESSED!");
        menuPage.clickContinue();
    }
    @And("I remove {string} from shopping cart")
    public void iRemoveFromShoppingCart(String removeProductName) {
        shoppingCartPage.clickProductRemove(removeProductName);
    }
    @And("I verify Shipping and Payment belongs to {string} and click to Edit Shipping")
    public void iVerifyShippingAndPaymentBelongsToAndClickToEditShipping(String name) {
        Map<String, String> user = TestContext.getDataByFileName(name);
        assertThat(checkoutConfirmationPage.getShippingName()).contains(user.get("firstName"), (user.get("lastName")));
        assertThat(checkoutConfirmationPage.getPaymentName()).contains(user.get("firstName"), (user.get("lastName")));
        checkoutConfirmationPage.clickEditShipping();
    }
    @And("I verify Shipping belongs to {string} and click to Confirm Order")
    public void iVerifyShippingBelongsToAndClickToConfirmOrder(String receiver) {
        Map<String, String> receiverName = TestContext.getDataByFileName(receiver);
        assertThat(checkoutConfirmationPage.getShippingName()).contains(receiverName.get("firstName"), (receiverName.get("lastName")));
        checkoutConfirmationPage.clickConfirmOrder();
    }
    @And("I fill out Login Name from customer {string}")
    public void iFillOutLoginNameFromCustomer(String user) {
        Map<String, String> customer = TestContext.getDataByFileName(user);
        accountLogin.fillOutLoginName(customer.get("loginName"));
    }
    @And("I fill out Password from customer {string}")
    public void iFillOutPasswordFromCustomer(String user) {
        Map<String, String> customer = TestContext.getDataByFileName(user);
        accountLogin.functionalityFillPassword(customer.get("password"));
    }
    @And("I verify alert {string}")
    public void iVerifyAlert(String alert) {
        assertThat(accountLogin.getAlertLogin().substring(1)).contains(alert);
        assertThat(accountLogin.getEmptyPassword()).isEmpty();
        System.out.println(">>>>>>>Alert: " + accountLogin.getAlertLogin().substring(1));
    }
    @And("I click Forgot your password?")
    public void iClickForgotYourPassword() {
        accountLogin.clickForgotPassword();
    }
    @And("I fill out Login Name and E-Mail Address {string}")
    public void iFillOutLoginNameAndEMailAddress(String user) {
        Map<String, String> customer = TestContext.getDataByFileName(user);
        accountLogin.fillOutForgottenLoginName(customer.get("loginName"));
        accountLogin.fillOutEmail(customer.get("email"));
    }
    @And("I click Forgot your login?")
    public void iClickForgotYourLogin() {
        accountLogin.clickForgotLogin();
    }
    @And("I fill out Last Name and E-Mail Address {string}")
    public void iFillOutLastNameAndEMailAddress(String user) {
        Map<String, String> customer = TestContext.getDataByFileName(user);
        accountLogin.fillOutLastName(customer.get("lastName"));
        accountLogin.fillOutEmail(customer.get("email"));
    }
    @And("I go to Manage Address Book and delete previous entries")
    public void iGoToManageAddressBookAndDeletePreviousEntries() {
        myAccountPage.clickManageAddressBook();
        myAccountPage.clickDeleteAddress();
    }
    @And("I verify success alert {string}")
    public void iVerifySuccessAlert(String alert) {
        assertThat(accountLogin.getSuccessAlertLogin().substring(1)).contains(alert);
        System.out.println(">>>>>>>Success alert: " + accountLogin.getSuccessAlertLogin().substring(1));
    }
    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000L);
    }
    @Then("I logout and verify authentication status")
    public void iLogoutAndVerifyAuthenticationStatus() {
        menuPage.clickWelcomeBackToAccount();
        menuPage.clickLogoff();
        assertThat(menuPage.getLoginOrRegister()).isEqualToIgnoringCase("Login or register");
    }
    @Then("I click Login")
    public void iClickLogin() {
        accountLogin.clickLoginButton();
    }
    @Then("I click reset continue button")
    public void iClickResetContinueButton() {
        accountLogin.clickResetContinue();
    }
}



