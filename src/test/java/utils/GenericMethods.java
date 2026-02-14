package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericMethods {
    public static void type(WebDriver driver, By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public static void click(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }
}
