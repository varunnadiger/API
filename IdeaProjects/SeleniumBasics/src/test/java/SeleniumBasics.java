import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SeleniumBasics {


    @Test
    public void testApp(){

       //  System.setProperty("webdriver.chrome.driver","F:\\Selenium\\chromedriver.exe");
        // ChromeDriver cd  = new ChromeDriver();
        // cd.get("https://kite.zerodha.com/dashboard");
         //cd.close();

        System.setProperty("webdriver.geko.driver","F:\\Selenium\\geckodriver.exe");

        FirefoxDriver fs= new FirefoxDriver();
         fs.get("https://kite.zerodha.com/dashboard");

    }
}
