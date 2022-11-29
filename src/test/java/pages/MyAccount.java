package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends Page {
    @FindBy(xpath = "//span[@class='subtext']")
    private WebElement myAccountName;
    @FindBy(xpath = "(//a[contains(@href,'account/address')])[4]")
    private WebElement manageAddressBookButton;
    @FindBy(xpath = "//button[@title='Delete']")
    private WebElement deleteButton;


    public String getMyAccountName() {
        return myAccountName.getText();
    }
    public void clickManageAddressBook() {
        manageAddressBookButton.click();
    }
    public void clickDeleteAddress() {
        try {
            while (deleteButton.isDisplayed()) {
                deleteButton.click();
            }
        } catch (NoSuchElementException e) {
        }
    }
}
