package serenityswag.authentication.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import serenityswag.authentication.User;

public class LogoutActions extends UIInteractionSteps {

    @Step("Logout as {0}")
    public void as(User user){
        find(By.id("react-burger-menu-btn")).click();
        waitForTextToAppear("Logout");
        find(By.linkText("Logout")).click();
    }
}
