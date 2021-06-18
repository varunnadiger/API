package Login;

import Base.Testbase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends Testbase {

    @Test
    public void login(){

        WebDriver driver = launchBrowser("Chrome");

       driver.get("in.yahoo.com");


    }
}
