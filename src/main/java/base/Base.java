package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.Prop;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver d;
    String driverPath;
    String url;
    Properties prop;
    public Base() throws IOException {
        Prop.properties();
        prop = Prop.prop;
    }

    public String getProp(String value){
        return prop.getProperty(value);
    }

    public void chromeInit()  {

        url = getProp("url");
        if(getProp("browser").equals("chrome")){
            System.setProperty(getProp("webdriver"),getProp("driverPath"));
            ChromeOptions options = new ChromeOptions();
            options.addArguments(getProp("headless"));
            options.addArguments(getProp("window"));
            d = new ChromeDriver(options);
        }
        else{
            System.setProperty(getProp("webdriver"),getProp("driverPath"));
            d = new FirefoxDriver();
        }
        d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        d.navigate().to(url);
    }
}
