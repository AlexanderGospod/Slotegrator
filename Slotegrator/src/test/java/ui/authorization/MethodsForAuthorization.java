package ui.authorization;

import ui.base_actions.SettingUpTheEnvironment;
import org.openqa.selenium.By;

public class MethodsForAuthorization extends SettingUpTheEnvironment {
    public static String adminLogin = "admin1";
    public static String adminPassword = "[9k<k8^z!+$$GkuP";


    public void navigationToAuthorizationTab(){
        String urlForAuthorizationPage = "http://test-app.d6.dev.devcaz.com/admin/login";
        driver.navigate().to(urlForAuthorizationPage);
    }
    public void waitingForTheVisibilityAuthorizationAdministratorTabLocator(){
        By authorizationAdministratorTabLocator = By.xpath("//*[contains(@action, 'admin/login')]");
        waitingForTheVisibilityOfTheElement(authorizationAdministratorTabLocator);
    }
    public void waitingForTheVisibilityAdminTabLocator(){
        By adminTabLocator = By.cssSelector(".fa-dashboard");
        waitingForTheVisibilityOfTheElement(adminTabLocator);
    }
    public void fillingInTheFieldsOnTheAuthorizationTab (String login, String password){
        driver.findElement(By.cssSelector("#UserLogin_username")).sendKeys(login);
        driver.findElement(By.cssSelector("#UserLogin_password")).sendKeys(password);
    }
    public void loginToSiteFromAuthorizationTab(){
        By signInButton = By.xpath("//*[@type='submit']");
        click(signInButton);
    }



}
