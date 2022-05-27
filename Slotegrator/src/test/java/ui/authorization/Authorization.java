package ui.authorization;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.By;


public class Authorization extends MethodsForAuthorization {

    @Дано("^страница авторизации$")
    public void страница_авторизации() throws Throwable {
        navigationToAuthorizationTab();
        waitingForTheVisibilityAuthorizationAdministratorTabLocator();
    }

    @Когда("^пользователь вводит логин \"([^\"]*)\" и пароль \"([^\"]*)\"$")
    public void пользователь_вводит_логин_и_пароль(String userLogin, String userPassword) throws Throwable {
        fillingInTheFieldsOnTheAuthorizationTab(userLogin, userPassword);
    }

    @Когда("^кликает 'Sign in'$")
    public void кликает_Sign_in() throws Throwable {
        loginToSiteFromAuthorizationTab();
    }

    @Тогда("^Пользователь успешно авторизован, админ-панель загрузилась$")
    public void пользователь_успешно_авторизован_админ_панель_загрузилась() throws Throwable {
        waitingForTheVisibilityAdminTabLocator();
    }

}
