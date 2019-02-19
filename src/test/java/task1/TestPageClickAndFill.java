package task1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import task1.PageObject.PageAutoInputAndClick;

import java.util.concurrent.TimeUnit;

public class TestPageClickAndFill {
    private static final String PAGE = "https://pastebin.com";
    private static final int TIME_OUT_SECOND = 10;
    private static final String NEW_PASTE_TEXT = "Hello from WebDriver";
    private static final String NAME_PASTE = "helloWeb";
    private static final String EXPIRATION_TIME_VALUE = "10M";

    private WebDriver driver;
    private PageAutoInputAndClick autoInputAndClick;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIME_OUT_SECOND, TimeUnit.SECONDS);
        driver.get(PAGE);
    }

    @Test
    public void testPasteBinPage() {
        autoInputAndClick =new PageAutoInputAndClick(driver);
        autoInputAndClick.insertTextPaste(NEW_PASTE_TEXT);
        autoInputAndClick.clickExpiration();
        autoInputAndClick.chooseExpirationTime(EXPIRATION_TIME_VALUE);
        autoInputAndClick.insertTextName(NAME_PASTE);
        driver.quit();
    }
}
