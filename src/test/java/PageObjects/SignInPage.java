package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SignInPage extends BaseObjects {

    public SignInPage(WebDriver driver) {
        super(driver);
        Driver = driver;
    }

    private By _errorMsgSignIn = By.xpath("//div[@class='alert alert-danger']//li");
    private By _errorMsgSignUp = By.xpath("//div[@id='create_account_error']/ol/li");
    private By _userName = By.xpath("//div[@class='header_user_info']/a/span");
    private By _login = By.id("email");
    private By _password = By.id("passwd");
    private By _signinButton = By.id("SubmitLogin");
    private By _forgotPasswordLink = By.xpath("//p[@class='lost_password form-group']");
    private By _loginButton = By.className("login");
    private By _createAccountBtn = By.id("SubmitCreate");
    private By _emailField = By.id("email_create");

    public void SignIn(String mail, String password) {
        getElement(_login).sendKeys(mail);
        getElement(_password).sendKeys(password);
        getElement(_signinButton).click();
    }

    public void OpenForgotPasswordPage() {
        getElement(_forgotPasswordLink).click();
    }

    public void SignUp(String mail) {
        getElement(_loginButton).click();
        getElement(_emailField).sendKeys(MakeNameWithDate(mail));
        getElement(_createAccountBtn).click();
    }

    private String MakeNameWithDate(String name)  //Its not good way
    {
        String full_name = "";
        Random r = new Random(1000);
        full_name = r + "_" + name;
        return full_name;
    }

    public String getUserName() {
        return getTextElement(_userName);
    }

    public String getErrorMsgLogin() {
        return getTextElement(_errorMsgSignIn);
    }

    public String getErrorMsgSignUp() {
        return getTextElement(_errorMsgSignUp);
    }
}
