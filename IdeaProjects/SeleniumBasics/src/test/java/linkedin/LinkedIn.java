package linkedin;

import Base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

import java.util.List;

public class LinkedIn extends Testbase {

    @Test
    public void linkedin(){
        System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"logs\\chrome.log");
        WebDriver driver = launchBrowser("Chrome") ;

        driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("abc@abc.com");
        WebElement password=  driver.findElement(By.id("password"));
        password.sendKeys("test");
        System.out.println(username.getLocation());
        System.out.println(password.getLocation());

        WebElement test = driver.findElement(By.xpath("//div[@class=\"login__form_action_container \"]"));
        test.click();


        }
}
