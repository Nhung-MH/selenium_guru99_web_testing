package Guru99Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC04_CheckCookie {
    @Test
    public void checkCookie(){
        // create driver
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // maximize brower window
        driver.manage().window().maximize();

        // open url
        String url = "http://automationpractice.com/index.php";
        driver.get(url);
        System.out.println(driver.manage().getCookies());
        driver.quit();
    }
}
