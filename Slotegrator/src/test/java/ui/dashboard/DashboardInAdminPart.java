package ui.dashboard;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import ui.authorization.MethodsForAuthorization;

public class DashboardInAdminPart extends MethodsForDashboardInAdminPart{

    @Дано("^Авторизованный админ в разделе 'Dashboard'$")
    public void авторизованный_админ_в_разделе_Dashboard() throws Throwable {
        MethodsForAuthorization authorization = new MethodsForAuthorization();
        authorization.navigationToAuthorizationTab();
        authorization.waitingForTheVisibilityAuthorizationAdministratorTabLocator();
        authorization.fillingInTheFieldsOnTheAuthorizationTab(authorization.adminLogin, authorization.adminPassword);
        authorization.loginToSiteFromAuthorizationTab();
        authorization.waitingForTheVisibilityAdminTabLocator();
        navigationToTheDashboard();
    }

    @Когда("^админ кликает 'Список пользователей'$")
    public void админ_кликает_Список_пользователей() throws Throwable {
        clickListOfGamers();
    }

    @Тогда("^Таблица с игроками загрузилась$")
    public void таблица_с_игроками_загрузилась() throws Throwable {
        checkingTheLoadingOfTheTableWithPlayers();
    }

    @Дано("^Авторизованный админ в разделе 'Список пользователей'$")
    public void авторизованный_админ_в_разделе_Список_пользователей() throws Throwable {
        MethodsForAuthorization authorization = new MethodsForAuthorization();
        authorization.navigationToAuthorizationTab();
        authorization.waitingForTheVisibilityAuthorizationAdministratorTabLocator();
        authorization.fillingInTheFieldsOnTheAuthorizationTab(authorization.adminLogin, authorization.adminPassword);
        authorization.loginToSiteFromAuthorizationTab();
        authorization.waitingForTheVisibilityAdminTabLocator();
        navigationToTheDashboard();
        clickListOfGamers();
    }

    @Когда("^Кликает на имя колонки \"([^\"]*)\"$")
    public void кликает_на_имя_колонки(String nameColumn) throws Throwable {
        clickColumnByItSNameInTableOfGamers(nameColumn);
    }

    @Тогда("^Таблица с игроками отсортировалась по возрастанию по колонке \"([^\"]*)\"$")
    public void таблица_с_игроками_отсортировалась_по_возрастанию_по_колонке(String nameColumn) throws Throwable {
        checkingThatColumnIsSortedByAscendingItSNames(nameColumn);
    }


}
