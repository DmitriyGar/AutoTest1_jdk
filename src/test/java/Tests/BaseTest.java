package Tests;

import PageObjects.Pages;
import Utilities.SeleniumDriver;
import org.junit.AfterClass;

public class BaseTest
{
        private static SeleniumDriver _selenium = new SeleniumDriver();
        private Pages _pages=null;
        protected Pages Pages;
        BaseTest(){
            if (Pages==null) {
                _pages = new Pages(_selenium.getDriver());
                Pages = _pages;
            }
        }


        @AfterClass
        public static void PostConditions()
        {
            _selenium.CloseDriver();
        }
}

