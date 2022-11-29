package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class ShoppingCart extends Page {

    @FindBy(xpath = "//a[@href='https://automationteststore.com/']")
    private WebElement continueShoppingButton;
    @FindBy(id = "cart_checkout2")
    private WebElement checkoutButton;
    @FindBy(xpath = "//td//span[contains(text(),'Retail')]")
    private WebElement retailTaxes;
    @FindBy(xpath = "//i[contains(@class,'fa-trash-o')]")
    private WebElement removeButton;
    @FindBy(xpath = "(//table[contains(@class,'table-bordered')])[1]")
    private WebElement shoppingCartTable;

    public String getShoppingCartProductName() {
        return shoppingCartTable.getText();
    }
    public WebElement getProductRemove(String removeProductName) {
        return getDriver().findElement(By.xpath("(//tr//a[text()='" + removeProductName + "']/following::*//a[@class='btn btn-sm btn-default'])[1]"));
    }
    public void clickContinueShopping() {
        waitUntilClickable(continueShoppingButton);
        continueShoppingButton.click();
    }
    public void clickCheckout() {
        waitUntilClickable(checkoutButton);
        checkoutButton.click();
    }
    public void clickProductRemove(String removeProductName) {
        getProductRemove(removeProductName).click();
    }
    public String getStateTaxes() {
        return retailTaxes.getText();
    }
    public void clickRemoveItem() {
        try {
            while (removeButton.isDisplayed()) {
                removeButton.click();
            }
        } catch (NoSuchElementException e) {
        }
    }
}
