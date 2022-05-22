package serenityswag.authentication;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;

public class LoginActions extends UIInteractionSteps {
    @Step("Log in as {0}")
    public void as(@NotNull User user) {
        openUrl("https://www.saucedemo.com/");

        // Login as a standard user
        $("[data-test='username']").sendKeys(user.getUsername());
        $("[data-test='password']").sendKeys(user.getPassword());
        $("[data-test='login-button']").click();
    }

}
