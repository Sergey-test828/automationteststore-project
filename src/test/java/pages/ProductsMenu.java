package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getDriver;

public class ProductsMenu extends Page {

    @FindBy(css = ".maintext")
    private WebElement productSubCategoryName;

    public String getProductName() {
        return productSubCategoryName.getText();
    }
    private WebElement getProductName(String product) {
        return getDriver().findElement(By.xpath("(//a[contains(text(),'" + product + "')])[1]"));
    }
    public void clickProductTitle(String product) {
        getProductName(product).click();
    }
}

