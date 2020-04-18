package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumDriver
{
    private WebDriver _driver;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        if (_driver == null) {
            System.setProperty("webdriver.chrome.driver", "D:\\DOC\\JavaProgs\\AutoTest1_jdk\\src\\test\\utils\\chromedriver.exe");
            _driver = new ChromeDriver();
            wait = new WebDriverWait(_driver, 10);
            _driver.manage().deleteAllCookies();
            _driver.get("http://automationpractice.com/index.php");
        }
        return _driver;
    }

    public void CloseDriver()
    {
        if (_driver != null) {
            _driver.quit();
            _driver = null;
        }
    }
}
