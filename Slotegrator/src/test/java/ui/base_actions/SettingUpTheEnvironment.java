package ui.base_actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class SettingUpTheEnvironment {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public  void start() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")  + "\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }
    public  void closeTheBrowser()  {
        driver.quit();
    }


    public void click (String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }
    public void clickWithCss (String css){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        driver.findElement(By.cssSelector(css)).click();
    }
    public void click (By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }
    public void waitingForTheVisibilityOfTheElement(By expectedLocator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectedLocator));
    }
    public void waitingForTheVisibilityOfTheElement(String xpath){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public void waitingForTheVisibilityOfTheElementByCss(String css){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }
}
