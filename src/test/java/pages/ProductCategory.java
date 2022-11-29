package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCategory extends Page {
    @FindBy(css = "span.maintext")
    private WebElement productCategoryName;
    @FindBy(xpath = "(//a[contains(@href,'product/category&path=49_50')])[2]")
    private WebElement productWomenCategory;
    @FindBy(css = "span.maintext")
    private WebElement womenCategoryName;
    @FindBy(xpath = "(//a[contains(@href,'product/product&path=49_50&product_id=64')])[1]")
    private WebElement beautyEayParfumButton;

    public String getSubCategoryName() {
        return productCategoryName.getText();
    }
    public void clickWomenCategory() {
        productWomenCategory.click();
    }
    public String getWomenCategoryName() {
        return womenCategoryName.getText();
    }
    public void clickBeautyEayParfum() {
        beautyEayParfumButton.click();
    }
}