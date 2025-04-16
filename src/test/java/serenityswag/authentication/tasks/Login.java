package serenityswag.authentication.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import serenityswag.authentication.actors.User;

public class Login extends UIInteractionSteps {


    @Step("Login as {0}")
    public void as(User user) {
        openUrl("https://www.saucedemo.com/");

        //Login as Standard User
        //Can use find too.
        $("[data-test='username']").sendKeys(user.getUsername());
        $("[data-test='password']").sendKeys(user.getPassword());
        $("[data-test='login-button']").click();
    }
}
