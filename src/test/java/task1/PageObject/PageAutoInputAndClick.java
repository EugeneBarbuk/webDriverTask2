package task1.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageAutoInputAndClick {
    private WebDriver driver;
    private By pasteField = By.id("paste_code");
    private By expirationFieldLocator = By.xpath("//*[@id='myform']//div[2]/div/span/span[1]/span");
    private By expirationTimeLocator = By.xpath("//*[@id='myform']/div[3]/div[2]/div[2]/select");
    private By nameField = By.xpath("//*[@id='myform']//div[5]/div[2]/input");

    public PageAutoInputAndClick(WebDriver driver) {
        this.driver = driver;
    }

    // Insert text in New Paste
    public void insertTextPaste(String text) {
        driver.findElement(pasteField).sendKeys(text);
    }

    // Click expiration paste
    public void clickExpiration() {
        driver.findElement(expirationFieldLocator).click();
    }

    // Choose expiration time
    public void chooseExpirationTime(String time) {
        Select expiration = new Select(driver.findElement(expirationTimeLocator));
        expiration.selectByValue(time);
    }

    // Insert text in Paste Name
    public void insertTextName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
}
