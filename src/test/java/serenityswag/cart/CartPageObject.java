package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    @FindBy(css = ".title")
    WebElementFacade title;

    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By TITLE = By.cssSelector(".title");
    private static final By CART_ITEMS = By.cssSelector(".cart_item");


    public void checkout() {
        $(CHECKOUT_BUTTON).click();
    }

    public String getTitleText() {
        return $(TITLE).getText();
    }

    public List<CartItem> items() {
        return findAll(CART_ITEMS).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceFrom(item.findBy(".inventory_item_price").getText())
                )
        );
    }

    @NotNull
    private Double priceFrom(@NotNull String textValue) {
        return Double.parseDouble(textValue.replace("$", ""));
    }

}
