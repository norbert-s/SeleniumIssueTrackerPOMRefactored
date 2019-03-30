package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetWaits {

    public WebDriverWait callWait(WebElement getJsonLocation, WebDriver d){
        WebDriverWait wait= new WebDriverWait(d,30);
        wait.until(ExpectedConditions.visibilityOf(getJsonLocation));
        return wait;
    }
}
