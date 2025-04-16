package serenityswag.authentication.tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class OpenProductDetail extends UIInteractionSteps {

    @Step("Open Product Details")
    public void For(String itemName) {
        find(By.linkText(itemName)).click();
    }
}
