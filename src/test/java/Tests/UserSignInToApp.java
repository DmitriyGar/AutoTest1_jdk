package Tests;


import Tests.TestData.TestData;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserSignInToApp extends BaseTest {

    @Before
    public void SetUp() {
        Pages.MainPage.NavigateToMainPage();
    }


    @Test
    public void UserCanSignIn() {
        Pages.MainPage.NavigateToSignInPage();
        Pages.SignInPage.SignIn(TestData.Mail, TestData.Password);
        Assert.assertEquals(TestData.First_name+" "+TestData.Last_name,Pages.SignInPage.getUserName());
    }


    @Test
    public void UserCanNotSignInWithIncorrectPassword() {
        Pages.MainPage.NavigateToSignInPage();
        Pages.SignInPage.SignIn(TestData.Mail, TestData.NegativePassword);
        Assert.assertEquals("Authentication failed.",Pages.SignInPage.getErrorMsgLogin());
    }

    @Test
    public void UserCanNotSignInWithIncorrectLogin() {
        Pages.MainPage.NavigateToSignInPage();
        Pages.SignInPage.SignIn(TestData.NegtiveMail, TestData.NegativePassword);
        Assert.assertEquals("Authentication failed.",Pages.SignInPage.getErrorMsgLogin());
    }

    @Test
    public void UserCanNotSignInWithoutCreds() {
        Pages.MainPage.NavigateToSignInPage();
        Pages.SignInPage.SignIn("", "");
        Assert.assertEquals("An email address required.",Pages.SignInPage.getErrorMsgLogin());
    }

    @After
    public void TierDown() {
        Pages.MainPage.LogOut();
    }
}
