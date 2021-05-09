package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPageTests {

    @Test
    public void dropdownPageToCheckAllOptionsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='dropdown']")));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> optionsToExist = new ArrayList<>(3);
        optionsToExist.add("Please select an option");
        optionsToExist.add("Option 1");
        optionsToExist.add("Option 2");
        for (int i = 0; i < dropdownOptions.size(); i++) {
            Assert.assertEquals(dropdownOptions.get(i).getText(), optionsToExist.get(i));
        }
        dropdown.selectByVisibleText(optionsToExist.get(1));
        Assert.assertTrue(dropdownOptions.get(1).isSelected());
        dropdown.selectByVisibleText(optionsToExist.get(2));
        Assert.assertTrue(dropdownOptions.get(2).isSelected());
        driver.quit();
    }
}
