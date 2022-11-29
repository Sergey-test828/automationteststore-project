package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class Menu extends Page {

    @FindBy(xpath = "//ul[@id='customer_menu_top']//a[contains(@href,account/login)]")
    private WebElement loginOrRegisterButton;
    @FindBy(xpath = "(//a[contains(@href,'product/category&path=49')])[1]")
    private WebElement fragranceButton;
    @FindBy(xpath = "//a[@href='https://automationteststore.com/']")
    private WebElement continueButton;
    @FindBy(xpath = "(//a[contains(@href,'account/account')])[1]")
    private WebElement welcomeBackButton;
    @FindBy(xpath = "(//a[contains(@href,'account/logout')])[4]")
    private WebElement logoffButton;
    @FindBy(css = ".block_7")
    private WebElement shoppingCartButton;


    public void clickLoginButton() {
        waitUntilClickable(loginOrRegisterButton);
        loginOrRegisterButton.click();
    }
    private WebElement getProductCategory(String productCategory) {
        return getDriver().findElement(By.xpath("(//*[contains(text(),'" + productCategory + "')][contains(@href,'product/category')])[1]"));
    }
    private WebElement getProductSubCategory(String subCategory) {
        return getDriver().findElement(By.xpath("(//a[contains(text(),'" + subCategory + "')][contains(@href,'product/category')])[1]"));
    }
    public void mouseOverCategoryMenu(String productCategory) {
        mouseOver(getProductCategory(productCategory));
    }
    public void clickSubCategory(String subCategory) {
        getProductSubCategory(subCategory).click();
    }
    public void clickFragrance() {
        fragranceButton.click();
    }
    public void clickContinue() {
        continueButton.click();
    }
    public void clickWelcomeBackToAccount() {
        welcomeBackButton.click();
    }
    public void clickLogoff() {
        logoffButton.click();
    }
    public String getLoginOrRegister() {
        return loginOrRegisterButton.getText();
    }
    public void clickShoppingCat() {
        shoppingCartButton.click();
    }
    public void clickLoginOrRegisterButton() {
        loginOrRegisterButton.click();
    }
}