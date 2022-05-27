package ui.dashboard;

import ui.base_actions.SettingUpTheEnvironment;
import org.junit.Assert;
import org.openqa.selenium.By;

public class MethodsForDashboardInAdminPart extends SettingUpTheEnvironment {

    public void navigationToTheDashboard() {
        clickWithCss(".fa-dashboard");
    }

    public void clickListOfGamers() {
        click("//*[contains(text(), 'Players online')]");
    }

    public void checkingTheLoadingOfTheTableWithPlayers() {
        By buttonForCreatingPlayer = By.xpath("//*[contains(text(), 'Create player')]");
        waitingForTheVisibilityOfTheElement(buttonForCreatingPlayer);
        By filterForGamers = By.cssSelector(".table >*>.filters");
        waitingForTheVisibilityOfTheElement(filterForGamers);
        Assert.assertTrue(driver.findElement(filterForGamers).isDisplayed());
    }

    public void clickColumnByItSNameInTableOfGamers(String nameColumn) {
        By columnForSortingLocator = By.xpath("//*[contains(@class, 'sort-link')][contains(text(), '" + nameColumn + "')]");
        click(columnForSortingLocator);
    }

    public void checkingThatColumnIsSortedByAscendingItSNames(String nameColumn) {
        waitingForTheVisibilityOfTheElement("//*[contains(@class, 'sort-link')][contains(text(), '" + nameColumn + "')][contains(@class, 'asc')]");
        int countForColumn = 0;
        for (int i = 1; i <= driver.findElements(By.cssSelector(".sort-link")).size(); i++) {
            if (driver.findElement(By.xpath("(//*[contains(@class, 'sort-link')])[" + i + "]")).getText().contains(nameColumn)){
                countForColumn = i+1; //первый столбец '#' > смещается номер в таблице на 1
                break;
            }
        }

        By columnForSortingLocator = By.xpath("//*[contains(@class, 'table')] /tbody /tr /td[" + countForColumn + "]");
        String firstValueToBeCompared = "";
        String secondValueToBeCompared = "";
        for (int i = 1; i < driver.findElements(columnForSortingLocator).size(); i++) {
            firstValueToBeCompared = driver.findElement(By.xpath("(//*[contains(@class, 'table')] /tbody /tr /td[" + countForColumn + "])[" + i + "]"))
                    .getText();
            secondValueToBeCompared = driver.findElement(By.xpath("(//*[contains(@class, 'table')] /tbody /tr /td[" + countForColumn + "])[" + (i+1) + "]"))
                    .getText();
            Assert.assertTrue("Товары не отсортированы по алфавиту (возрастанию)"
                    , firstValueToBeCompared.compareTo(secondValueToBeCompared) <= 0);
        }
    }

}
