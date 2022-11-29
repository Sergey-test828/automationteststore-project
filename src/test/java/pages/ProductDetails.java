package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static support.TestContext.getDriver;

public class ProductDetails extends Page {

    @FindBy(css = "span.bgnone")
    private WebElement productDetailsName;
    @FindBy(css = "a.cart")
    private WebElement addToCartButton;
    @FindBy(css = "span.bgnone")
    private WebElement beautyEayParfumName;
    @FindBy(id = "product_quantity")
    private WebElement productQuantity;

    public String getProductName() {
        return productDetailsName.getText();
    }
    public void clickAddToCart() {
        addToCartButton.click();
    }
    public String getBeautyEayParfum() {
        return beautyEayParfumName.getText();
    }
    public void emptyingQuantity() {
        scrollBy(addToCartButton, 0, 200);
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("document.getElementById('product_quantity').setAttribute('value', ' ')");
    }
    public void sendKeysToQuantity(String quantity) {
        productQuantity.sendKeys(quantity);
    }
    public WebElement getProductSize(String size) {
        return getDriver().findElement(By.xpath("//option[contains(text(),'" + size + "')]"));
    }
    public void sendKeysToSize(String size) {
        getProductSize(size).click();
    }
}
