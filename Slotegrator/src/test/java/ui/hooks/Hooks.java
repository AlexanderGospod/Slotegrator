package ui.hooks;

import ui.base_actions.SettingUpTheEnvironment;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    SettingUpTheEnvironment set = new SettingUpTheEnvironment();

    @Before ()
    public void initialization() {
        set.start();
    }

    @After
    public void threatDown() {
        set.closeTheBrowser();
    }
}
