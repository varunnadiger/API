package Base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Testbase {

    WebDriver driver;
    public WebDriver launchBrowser(String browserName){

     //   System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");

        if(browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"logs\\chrome.log");
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            ops.addArguments("start-maximized");
            driver = new ChromeDriver(ops);

           // driver.manage().window().maximize();
        }
        else if (browserName.equals("firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            WebDriverWait wait=new WebDriverWait(driver, 20);
        }


        return driver;
    }
    protected void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(fileWithPath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }

}
