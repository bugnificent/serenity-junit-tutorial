package serenityswag.authentication.abilities;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.questions.ProductDetails;
import serenityswag.authentication.tasks.Login;
import serenityswag.authentication.tasks.OpenProductDetail;
import serenityswag.authentication.pages.InventoryPage;
import serenityswag.authentication.actors.User;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenViewingHighlightedProducts {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    Login login;
    OpenProductDetail openProductDetails;

    ProductDetails productDetailsPage;
    InventoryPage inventoryPage;

    @Test
    public void shouldDisplayHighlightedProductsOnTheInventoryPage() {
        login.as(User.STANDARD_USER);

        List<String> productsOnDisplay = inventoryPage.getProductTitles();

        Serenity.reportThat("Highlighted Products has count as 6 and contains Sauce Labs Backpack",
                () -> assertThat(productsOnDisplay).hasSize(6)
                        .contains("Sauce Labs Backpack")
        );

    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage() {

        login.as(User.STANDARD_USER);

        String firstItemName = inventoryPage.getProductTitles().get(0);

        openProductDetails.For(firstItemName);

        Serenity.reportThat("OpenProductDetail details should contain " + firstItemName,
                () -> assertThat(productDetailsPage.productName()).isEqualToIgnoringCase("Sauce Labs Backpack")
        );

        Serenity.reportThat("OpenProductDetail details should contain " + firstItemName,
                () -> productDetailsPage.productImageWithAltValueOf(firstItemName).shouldBeVisible()
        );

    }
}
