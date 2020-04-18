package PageObjects;

import org.openqa.selenium.WebDriver;

public class Pages
{
    public MainPage MainPage;
    public SignInPage SignInPage;
 /*   public CreateAccountPage CreateAccountPage;
    public SearchProductsBlock SearchProductsBlock ;
    public ProductItemFrame ProductItemFrame ;
    public CartLayer CartLayer;
    public CartPage CartPage ;*/
    public Pages(WebDriver driver)
    {
        if (MainPage == null)
            MainPage = new MainPage(driver);
        if (SignInPage == null)
            SignInPage = new SignInPage(driver);
 /*       if (CreateAccountPage == null)
            CreateAccountPage = new CreateAccountPage(driver);
        if (SearchProductsBlock == null)
            SearchProductsBlock = new SearchProductsBlock(driver);
        if (ProductItemFrame == null)
            ProductItemFrame = new ProductItemFrame(driver);
        if (CartLayer == null)
            CartLayer = new CartLayer(driver);
        if (CartPage == null)
            CartPage = new CartPage(driver);*/
    }
}