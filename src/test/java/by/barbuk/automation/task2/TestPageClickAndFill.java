package by.barbuk.automation.task2;

import by.barbuk.automation.task2.PageObject.PageAutoInputAndClick;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPageClickAndFill {
    private static final String PAGE = "https://pastebin.com";
    private static final int TIME_OUT_SECOND = 10;
    private static final String NEW_PASTE_TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String NAME_PASTE = "how to gain dominance among developers";
    private static final String EXPIRATION_TIME_VALUE = "10M";
    private static final String SYNTAX_NAME = "Bash";

    private WebDriver driver;
    private PageAutoInputAndClick pageAutoInputAndClick;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIME_OUT_SECOND, TimeUnit.SECONDS);
        driver.get(PAGE);
    }

    @Test
    public void testPasteBinPage() {
        pageAutoInputAndClick = new PageAutoInputAndClick(driver);
        pageAutoInputAndClick.insertTextPaste(NEW_PASTE_TEXT);
        pageAutoInputAndClick.clickSyntax();
        pageAutoInputAndClick.chooseSyntax(SYNTAX_NAME);
        pageAutoInputAndClick.clickSyntax();
        pageAutoInputAndClick.clickExpiration();
        pageAutoInputAndClick.chooseExpirationTime(EXPIRATION_TIME_VALUE);
        pageAutoInputAndClick.clickExpiration();
        pageAutoInputAndClick.insertTextName(NAME_PASTE);
        pageAutoInputAndClick.clickCreateNewPast();
    }

    @Test
    public void testTitleEquals() {
        Assert.assertEquals(NAME_PASTE, driver.findElement(By.xpath("//*/h1")).getText());
    }

    @Test
    public void testTextSyntax() {
        Assert.assertEquals(SYNTAX_NAME, driver.findElement(By.xpath("//*/span[2]/a")).getText());
    }

    @Test
    public void testPasteText() {
        Assert.assertEquals(NEW_PASTE_TEXT, driver.findElement(By.xpath("//*/ol")).getText());
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
