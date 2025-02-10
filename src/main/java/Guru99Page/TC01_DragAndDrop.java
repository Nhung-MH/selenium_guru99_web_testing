package Guru99Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TC01_DragAndDrop {

    @Test
    public void dragAndDrop() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://demo.guru99.com/test/drag_drop.html";
        driver.get(url);

        Thread.sleep(1000);
        WebElement button5000 = driver.findElement(By.xpath("/html//li[@id='fourth']/a[@class='button button-orange']"));

        WebElement buttonBank = driver.findElement(By.xpath("//div[@id='products']//li[@class='block14 ui-draggable']/a[@class='button button-orange']"));
        WebElement textBoxAmount = driver.findElement(By.xpath("/html//main[@id='g-mainbar']/div[@class='g-grid']/div[@class='g-block size-100']//div[@class='item-page']/table/tbody/tr/td[1]/table//tr/td[2]/div[@class='shoppingCart']//ol[@class='field13 ui-droppable ui-sortable']/li[@class='placeholder']"));
        WebElement textBoxAccount = driver.findElement(By.xpath("//ol[@id='bank']/li[@class='placeholder']"));

        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(button5000,textBoxAmount).build().perform();
        Thread.sleep(1000);
        actions.dragAndDrop(buttonBank,textBoxAccount).build().perform();
        Thread.sleep(1000);
        driver.quit();
    }

}
