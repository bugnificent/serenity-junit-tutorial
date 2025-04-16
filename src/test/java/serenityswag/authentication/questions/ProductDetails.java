package serenityswag.authentication.questions;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementState;

public class ProductDetails extends PageObject {


    public String productName() {
        return $("[data-test='inventory-item-name']").getText();
    }

    //Not good practice to directly interact WebElements and manipulate them, can cause flaky tests.
    //Instead we can use special serenity class which is return value of this method to assert current state.
    public WebElementState productImageWithAltValueOf(String firstItemName) {
        return $(".inventory_details_container img[alt='" + firstItemName + "']");
//Or can use        return $("css:img[alt='"+ firstItemName +"']");
    }
}