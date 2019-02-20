package by.barbuk.automation.task2.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PageAutoInputAndClick {
    private WebDriver driver;
    private By pasteField = By.id("paste_code");
    private By expirationFieldLocator = By.xpath("//*/div[2]/div/span/span[1]/span");
    private By expirationValueLocator = By.xpath("//*/div[2]/div[2]/select");
    private By nameField = By.xpath("//*/div[5]/div[2]/input");
    private By syntaxFieldLocator = By.xpath("//*/div[1]/div[2]/span");
    private By syntaxValueLocator = By.xpath("//*/div[1]/div[2]/select");
    private By createNewPasteBtn = By.xpath("//*[@id='submit']");

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
        Select expiration = new Select(driver.findElement(expirationValueLocator));
        expiration.selectByValue(time);
    }

    // Insert text in Paste Name
    public void insertTextName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Click Syntax Highlighting
    public void clickSyntax() {
        driver.findElement(syntaxFieldLocator).click();
    }

    // Choose Syntax Highlighting
    public void chooseSyntax(String syntax) {
        Select expiration = new Select(driver.findElement(syntaxValueLocator));
        expiration.selectByVisibleText(syntax);
    }

    // Saving new Paste
    public void clickCreateNewPast() {
        driver.findElement(createNewPasteBtn).click();
    }
}
