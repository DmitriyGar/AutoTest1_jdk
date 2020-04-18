package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseObjects{


    public MainPage(WebDriver driver)  {
        super(driver);
        Driver=driver;

}

    private By _logOutButton = By.className("logout");
    private By _logInButton = By.xpath("//a[@class='login']");
    private By _errorMsgSignIn = By.xpath("//div[@class='alert alert-danger']//li");
    private By _errorMsgSignUp = By.xpath("//div[@id='create_account_error']/ol/li");
    private By _contactUsButton = By.id("contact-link");
    private By _tShortTab = By.xpath("//li/a[contains(text(),'T-shirts') and @title='T-shirts'] ");
    public WebElement LogOutButton;

    public void NavigateToMainPage() {
        Driver.get("http://automationpractice.com/index.php");
    }

    public void NavigateToSignInPage() {
        getElement(_logInButton).click();
    }

    public void OpenTshirtTopic() {
    getElement(_tShortTab).click();
    }

    public void LogOut() {
            try{
                LogOutButton=getElement(_logOutButton);
            }catch (Exception e){
                System.err.println("Logout is null");
            }
        if (LogOutButton!=null)
           LogOutButton.click();
    }
}