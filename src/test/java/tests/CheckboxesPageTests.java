package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckboxesPageTests {

    @Test
    public void checkboxesPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Assert.assertFalse(checkboxes.get(0).isSelected());
        checkboxes.get(0).click();
        Assert.assertTrue(checkboxes.get(0).isSelected());
        Assert.assertTrue(checkboxes.get(1).isSelected());
        checkboxes.get(1).click();
        Assert.assertFalse(checkboxes.get(1).isSelected());
        driver.quit();
    }
}
