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

public class TC03_CheckRightClickButton {
    @Test
    public void checkRightClick () throws IOException, AWTException, InterruptedException {
        // create driver
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // maximize brower window
        driver.manage().window().maximize();

        // open url
        String url = "http://demo.guru99.com/test/simple_context_menu.html";
        driver.get(url);

        // find right click button
        WebElement rightClickButton = driver.findElement(By.cssSelector(".context-menu-one"));

        // verify right click button display
        Assert.assertTrue(rightClickButton.isDisplayed() == true, "right click button is NOT display");

        // click right button
        Actions action = new Actions(driver);
        action.contextClick(rightClickButton).perform();

        // Click on Edit link on the displayed menu options
        WebElement edit = driver.findElement(By.cssSelector(".context-menu-icon-edit"));
        edit.click();

        // capture alert
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "jpg", new File("ex3.jpg"));
        Thread.sleep(1000);
        driver.quit();
    }
}
