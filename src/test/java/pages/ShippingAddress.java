package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;

public class ShippingAddress extends Page {

    @FindBy(id = "Address2Frm_firstname")
    private WebElement firstNameField;
    @FindBy(id = "Address2Frm_lastname")
    private WebElement secondNameField;
    @FindBy(id = "Address2Frm_address_1")
    private WebElement addressField;
    @FindBy(id = "Address2Frm_country_id")
    private WebElement countryField;
    @FindBy(id = "Address2Frm_zone_id")
    private WebElement stateField;
    @FindBy(id = "Address2Frm_postcode")
    private WebElement zipField;
    @FindBy(id = "Address2Frm_city")
    private WebElement cityField;
    @FindBy(xpath = "(//i[contains(@class,'fa-arrow-right')])[2]")
    private WebElement continueRefreshButton;


    public void shippingAddressFields(Map<String, String> receiverName) {
        firstNameField.sendKeys(receiverName.get("firstName"));
        secondNameField.sendKeys(receiverName.get("lastName"));
        addressField.sendKeys(receiverName.get("address1"));
        countryField.sendKeys(receiverName.get("country"));
        zipField.sendKeys(receiverName.get("zip"));
        cityField.sendKeys(receiverName.get("city"));
        selectState(receiverName.get("state"));

    }
    public void selectState(String state) {
        new Select(stateField).selectByVisibleText(state);
    }
    public void clickContinueRefresh() {
        waitUntilClickable(continueRefreshButton);
        continueRefreshButton.click();
    }
}
