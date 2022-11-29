package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutConfirmation extends Page {

    @FindBy(xpath = "//td[@class='align_left valign_top']//a[contains(@href,'product&product_id=64')]")
    private WebElement orderSummary;
    @FindBy(id = "checkout_btn")
    private WebElement confirmOrderButton;
    @FindBy(css = "span.maintext")
    private WebElement orderHasBeenProcessed;
    @FindBy(xpath = "//*[contains(@class,'alert-info')]")
    private WebElement waitAlertSpinner;
    @FindBy(xpath = "//table[contains(@class,'confirm_shippment_options')]")
    private WebElement shippingName;
    @FindBy(xpath = "//table[contains(@class,'confirm_payment_options')]")
    private WebElement paymentName;
    @FindBy(xpath = "//a[contains(@href,'checkout/shipping&mode=edit')]")
    private WebElement editShippingButton;

    public String getOrderSummary() {
        return orderSummary.getText();
    }
    public void clickConfirmOrder() {
        confirmOrderButton.click();
        waitUntilInvisible(waitAlertSpinner);
    }
    public String getCheckoutSuccess() {
        return orderHasBeenProcessed.getText();
    }
    public String getShippingName() {
        return shippingName.getText();
    }
    public String getPaymentName() {
        return paymentName.getText();
    }
    public void clickEditShipping() {
        editShippingButton.click();
    }
}

