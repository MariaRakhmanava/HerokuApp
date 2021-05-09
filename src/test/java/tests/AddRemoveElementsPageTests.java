package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddRemoveElementsPageTests {

    @Test
    public void addRemoveElementsPageTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementsButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        addElementsButton.click();
        addElementsButton.click();
        driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        List<WebElement> elementsAdded = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(elementsAdded.size(), 1);
        driver.quit();
    }
}
