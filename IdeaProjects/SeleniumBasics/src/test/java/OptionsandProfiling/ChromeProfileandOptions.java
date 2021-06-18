package OptionsandProfiling;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ChromeProfileandOptions {


        @Test

    public void chrome() throws IllegalMonitorStateException, InterruptedException {
            System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"logs\\chrome.log");
          //  System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
            ChromeOptions ops = new ChromeOptions();

            ops.addArguments("--Disable Notifications");
            ops.addArguments("--start Manximized");

            ops.addArguments("--ignore-certificate-errors");
            ops.addArguments("--proxy-server");

            ChromeDriver cd  = new ChromeDriver();
            cd.manage().window().maximize();
            cd.get("http://pushengage.com/demo");
          //  cd.wait(10000);
          //  cd.close();

        }


}
