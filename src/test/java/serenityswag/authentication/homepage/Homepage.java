package serenityswag.authentication.homepage;

import net.serenitybdd.core.pages.PageObject;

public class Homepage extends PageObject {
    public String getHeading() {
        return $(".login_logo").getText();
    }
}