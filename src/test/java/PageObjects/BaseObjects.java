package PageObjects;


import com.google.common.base.Stopwatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BaseObjects
{
    protected BaseObjects(WebDriver driver)
    {
        Driver = driver;

    }
    protected WebDriver Driver;

    protected WebElement getElement( By locator)
    {
        Stopwatch wait = Stopwatch.createStarted();
        WebElement element = null;
        while (element == null)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try{
                element = Driver.findElement(locator);
            }catch (Exception e){
                System.err.println(" Locator not found");
            }
            if (wait.elapsed(TimeUnit.MILLISECONDS) > 30 && element == null)
            {
                throw new NoSuchElementException("Locator not found: "+locator);
            }
        }
        wait.stop();
        return element;
    }

    protected String getTextElement(By element)
    {
        String getText = "";
        if (getElement(element).getText().trim()!=null)
            getText = getElement(element).getText().trim();
        return getText;
    }
}