package ui;

import org.testng.annotations.AfterMethod;
import pages.BasePage;

public class BaseTest {

    @AfterMethod
    public void tearDown() {
        BasePage.quitDriver();
    }
}
