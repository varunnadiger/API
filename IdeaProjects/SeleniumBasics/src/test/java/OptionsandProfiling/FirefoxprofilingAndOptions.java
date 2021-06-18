package OptionsandProfiling;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

public class FirefoxprofilingAndOptions {

//set binary
    //disable notification
    //maximize the broser
    //certificate error
    //Work with Proxy - this is not done
    //page load stratergy



    @Test
    public void firefox(){

        //System.setProperty("webdriver.geko.driver","F:\\Selenium\\geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"logs\\firefox.log");
        FirefoxOptions options = new FirefoxOptions();
        //options.setPageLoadStrategy()
        //This is required if the firefox is not found
       //  options.setBinary("\"C:\\Program Files\\Mozilla Firefox\\firefox.exe\"");
        ProfilesIni allProf = new ProfilesIni(); // all the profiles
        FirefoxProfile prof = allProf.getProfile("default");


        //notification
        prof.setPreference("dom.webnofitification.enabled", false);
        prof.setAssumeUntrustedCertificateIssuer(true);
        prof.setAssumeUntrustedCertificateIssuer(false);
        options.setProfile(prof);

        FirefoxDriver fs= new FirefoxDriver(options);
        fs.get("http://pushengage.com/demo");

    }


}
