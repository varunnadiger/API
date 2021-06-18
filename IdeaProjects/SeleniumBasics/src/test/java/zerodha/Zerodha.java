package zerodha;

import Base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import javax.xml.bind.SchemaOutputResolver;


@Test
public class Zerodha extends Testbase {


    public void zerodhaChrome() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"logs\\chrome.log");

        WebDriver driver = launchBrowser("Chrome");

        driver.get("https://kite.zerodha.com/");
        System.out.println("The title is: " +driver.getTitle());
        String title = "Kite - Zerodha's fast and elegant flagship trading platform";
      //  ChromeOptions ops = new ChromeOptions();

        if (driver.getTitle().equals(title))        {
            WebElement userName = driver.findElement(By.xpath("//input[@id=\"userid\"]"));
            userName.sendKeys("ABC123");
            WebElement password = driver.findElement(By.xpath("//input[@id=\"password\"]"));
            password.sendKeys("55555");

            WebElement submit = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            submit.click();

            Thread.sleep(1000);
            WebElement pin = driver.findElement(By.xpath(" //input[@id=\"pin\"]"));
            pin.sendKeys("226555");


            WebElement pinSubmit = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
            pinSubmit.click();


        }
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //to search a Stock in the page


   WebElement searchSymbol =  driver.findElement(By.xpath("//input[@id=\"search-input\"]"));
    searchSymbol.click();
       final JDialog dialog = new JDialog();
      dialog.setAlwaysOnTop(true);

      String otp = JOptionPane.showInputDialog(dialog, "Enter the symbol to search", "Enter Symbol", JOptionPane.INFORMATION_MESSAGE);
       searchSymbol.sendKeys(otp);

      WebElement selectSymbol= driver.findElement(By.id("//li[@class='search-result-item selected']"));

          // selectSymbol.click();

        WebElement clickOnPlus=  driver.findElement(By.id("//span[@class='icon icon-plus']"));

        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(selectSymbol).perform();
        clickOnPlus.click();
        Thread.sleep(10000);




        //Refresh the Holding page every minute
//
//      for ( int i=0; i< 100000;i++){
//           WebElement clickHolding = driver.findElement(By.xpath("//span[contains(text(),'Holdings')]"));
//           clickHolding.click();
//          //driver.navigate().refresh();
//
//           System.out.println("The current Iteration :" +i);
//          System.out.println(driver.getTitle());
//           js.executeScript("window.scrollBy(0,1000)");
//            Thread.sleep(60000);
//
//
//    }



        driver.quit();

    }


}
