package NullPackage;

import Base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NullSkillPackageTest extends Testbase {

   @Test
    public void NullSkillPackage() throws Exception {
       System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
       System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"logs\\chrome.log");

       WebDriver driver =   launchBrowser("Chrome");
       driver.get("http://nullskull.com/articles/SumCaptchaTest.aspx");

        Thread.sleep(10000);

        String email = "abc@abc.com";

        WebElement element = driver.findElement(By.xpath("//input[@id=\"email\"]"));
        element.sendKeys(email);
        int firstNumber = Integer.parseInt(driver.findElement(By.xpath("//span[@id=\"lblNum1\"]")).getText());
       // System.out.println(firstNumber);
        int secondNumber = Integer.parseInt(driver.findElement(By.xpath("//span[@id=\"lblNum2\"]")).getText());
       // System.out.println(secondNumber);
        int sum =  firstNumber + secondNumber;

       System.out.println(sum);
        //Assert.assertEquals();

       WebElement textSum = driver.findElement(By.xpath("//input[@id=\"txtSum\"]"));
       textSum.sendKeys(String.valueOf(sum));

       WebElement submitButton  = driver.findElement(By.xpath("//input[@id=\"Button1\"]"));
       submitButton.click();

      // Thread.sleep(10000);
       WebDriverWait wait=new WebDriverWait(driver, 50);
       WebElement successMessage;
             //  driver.findElement(By.id("//span[@id='Label2']"));
       successMessage =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='Label2']")));
       //System.out.println(successMessage.getText());
       takeSnapShot(driver, "logs\\test.png");
       Assert.assertEquals(successMessage.getText(),"Success!");

       driver.quit();

    }

}
