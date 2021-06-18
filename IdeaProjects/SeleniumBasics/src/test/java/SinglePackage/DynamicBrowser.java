package SinglePackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicBrowser {


    @Test
    public void launch(){
        String browser = "Chrome";

        WebDriver driver = null;
           System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");

           if(browser.equals("Chrome"))

               driver = new ChromeDriver();
           else if (browser.equals("firefox"))
                driver = new FirefoxDriver();
           driver.get("https://in.yahoo.com/");
        System.out.println("Te title is " + driver.getTitle());

        Assert.assertEquals( driver.getTitle(), "Yahoo India | News, Finance, Cricket, Lifestyle and Entertainment");
    }


}
