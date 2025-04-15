package serenityswag.authentication.actions;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractionSteps {


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
