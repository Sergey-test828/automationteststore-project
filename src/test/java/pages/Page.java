package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static support.TestContext.getDriver;

public class Page {

    protected String url;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }
    public void open() {
        getDriver().get(url);
    }
    public WebDriverWait getWait() {
        return getWait(5);
    }
    public WebDriverWait getWait(int secondsTimeout) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(secondsTimeout));
    }
    public Actions getActions() {
        return new Actions(getDriver());
    }
    public void mouseOver(WebElement element) {
        getActions().moveToElement(element).perform();
    }
    public void waitUntilInvisible(WebElement element) {
        getWait().until(ExpectedConditions.invisibilityOf(element));
    }
    public void waitUntilClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollBy(WebElement element, int xOffset, int yOffset) {
        new Actions(getDriver()).moveToElement(element).perform();
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(" + xOffset + ", " + yOffset + ");");
    }
}


