package serenityswag.authentication;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.authentication.actions.LogoutActions;
import serenityswag.authentication.homepage.Homepage;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

//Inject Serenity Library
@ExtendWith(SerenityJUnit5Extension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@Nested
public class WhenLoggingOn {

    //Managed Annotation from Serenity will clear when test ends. unique session will help after each test so driver wont close browser.
    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;

    @Steps

    LoginActions login;
    LogoutActions logout;

    InventoryPage inventoryPage;
    Homepage homepage;

    @Test
    @Order(1)
    public void usersCanLogOnViaTheHomePage() {

        login.as(STANDARD_USER);

        Serenity.reportThat("The inventory page should be displayed with the correct title",

                () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products")

        );

    }

    @Test
    @Order(2)
    public void usersCanLogOutViaInventory() {

        logout.as(User.LOCKED_OUT_USER);

        Serenity.reportThat("The home page should be displayed to see we logged out",

                () -> assertThat(homepage.getHeading()).isEqualToIgnoringCase("Swag Labs")

        );

    }
}
