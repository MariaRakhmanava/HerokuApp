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
        // int numberOfDeleteButtons = 0;
        addElementsButton.click();
        // numberOfDeleteButtons++;
        addElementsButton.click();
        // numberOfDeleteButtons++;
        driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        List<WebElement> elementsAdded = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        // numberOfDeleteButtons--;
        Assert.assertEquals(elementsAdded.size(), 1);
        /* хотя конечно вышестоящая строка по-хорошему должна бы выглядеть так:
        Assert.assertEquals(elementsAdded.size(), numberOfDeleteButtons);
         */
        driver.quit();
    }

    /*
       Очень плохенько написано, особенно этот кусок кода:

        ...
        addElementsButton.click();
        numberOfDeleteButtons++;
        addElementsButton.click();
        numberOfDeleteButtons++;
        ...
        List<WebElement> elementsAdded = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        numberOfDeleteButtons--;
        Assert.assertEquals(elementsAdded.size(), 1);

        Я думала создать класс WebElementSpecified, который наследовал бы класс RemoteWebElement, и в нем бы
        переопределила метод click() таким образом, чтобы считалось количество добавленных элементов, то есть,
        я хотела в код метода добавить объявление переменной типа int numberOfAddedElements
        и докинуть к коду метода инструкцию numberOfAddedElements++ после всех родных инструкций метода, но
        метод написан на Javascript и моя идея с переопределением метода click() упала:(
        Еще думала цикл while попробовать дать, while (addElementsButton.click()) numberOfAddedElements++;
        но здесь же условие в скобках должно иметь тип булева значения, а наш метод click() по типу void,
        поэтому и здесь я села в лужу и написала коряво так
     */
}
