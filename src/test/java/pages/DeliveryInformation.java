package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryInformation extends Page {

    @FindBy(xpath = "//a[contains(@href,'checkout/address/shipping')]")
    private WebElement changeAddressButton;

    public void clickChangeAddress() {
        changeAddressButton.click();
    }
}
