package serenityswag.authentication.pages;

import net.serenitybdd.core.pages.PageObject;

public class HomePage extends PageObject {

    public String getHeading() {
        return $(".login_logo").getText();
    }

}