package tests;

import base.BaseTest;
import utils.GenericMethods;
import utils.ScreenshotUtil;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 2)
    @Parameters({"username","password"})
    public void validLogin(String username, String password) throws Exception {

        GenericMethods.type(driver, By.id("user-name"), username);
        GenericMethods.type(driver, By.id("password"), password);
        GenericMethods.click(driver, By.id("login-button"));

        Assert.assertTrue(driver.getTitle().contains("Swag Labs"));
        ScreenshotUtil.captureScreenshot(driver, "ValidLogin");
    }

    @Test(priority = 3)
    @Parameters({"invalidUser","invalidPwd"})
    public void invalidLogin(String user, String pwd) throws Exception {

        driver.navigate().refresh();

        GenericMethods.type(driver, By.id("user-name"), user);
        GenericMethods.type(driver, By.id("password"), pwd);
        GenericMethods.click(driver, By.id("login-button"));

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
        ScreenshotUtil.captureScreenshot(driver, "InvalidLogin");
    }
}
