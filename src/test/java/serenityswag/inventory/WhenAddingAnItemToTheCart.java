package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.LoginActions;
import serenityswag.cart.CardActions;
import serenityswag.cart.ShoppingCartIcon;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static serenityswag.authentication.User.STANDARD_USER;

@RunWith(SerenityRunner.class)
public class WhenAddingAnItemToTheCart {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginActions login;

    @Before
    public void login() {
        login.as(STANDARD_USER);
    }

    ShoppingCartIcon shoppingCartBadge;

    @Steps
    CardActions cart;

    @Test
    public void theCorrectItemCountShouldBeShown() {
        //Check that the shopping cart badge is empty
        Serenity.reportThat("The shopping cart badge should be empty",
                ()-> assertThat(shoppingCartBadge.badgeCount()).isEmpty()
        );

        //Add 1 item to the cart
        cart.addItem("Sauce Labs Backpack");

        //The shopping cart badge should be 1
        Serenity.reportThat("The shopping cart badge should now be 1",
                ()->  assertThat(shoppingCartBadge.badgeCount()).isEqualTo("1")
        );
    }

    ProductList productList;
    
    @Test
    public void allTheItemsShouldAppearInTheCart() {
        //Add several item to the cart
        List<String> selectedItems= firstThreeProductTitlesDisplayed();
        
        //Open the cart page
        cart.adItems(selectedItems);

        String cartBadgeCount= Integer.toString(selectedItems.size());
        Serenity.reportThat("The shopping cart badge should now be " + cartBadgeCount,
                ()->  assertThat(shoppingCartBadge.badgeCount()).isEqualTo(cartBadgeCount)
        );

        cart.openCart();

        //Should see all the item listed
        Serenity.reportThat("Should see all the items listed " ,
                ()->         assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems)
        );
    }

    @NotNull
    private List<String> firstThreeProductTitlesDisplayed() {
        return productList.titles().subList(0, 3);
    }
}
