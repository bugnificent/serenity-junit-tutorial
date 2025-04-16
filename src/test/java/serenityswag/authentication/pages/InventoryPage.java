package serenityswag.authentication.pages;


import net.serenitybdd.core.pages.PageObject;

import java.util.List;

public class InventoryPage extends PageObject {

    public String getHeading() {
        return $(".title").getText();
    }

    public List<String> getProductTitles() {
        return findAll(".inventory_item_name").textContents();
    }
}