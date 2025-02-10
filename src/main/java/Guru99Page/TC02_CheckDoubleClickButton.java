package Guru99Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TC02_CheckDoubleClickButton {
    @Test
    public void checkDoubleClickButton() throws InterruptedException, AWTException, IOException {
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "http://demo.guru99.com/test/simple_context_menu.html";
        driver.get(url);
        Thread.sleep(1000);

        WebElement doubleClickButton = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));

        // Verify "doubleClickButton" is displayed
        Assert.assertTrue(doubleClickButton.isDisplayed() == true, "doubleClickButton is NOT Displayed");

        Actions action = new Actions(driver);
        action.doubleClick(doubleClickButton).perform();

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File("ex2.jpg"));
        Thread.sleep(2000);
        driver.quit();
    }
}
