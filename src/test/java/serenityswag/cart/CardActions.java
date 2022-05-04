package serenityswag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;
import serenityswag.inventory.ProductList;

import java.util.List;

public class CardActions extends UIInteractionSteps {

    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        $(ProductList.addToCartButtonFor(itemName)).click();
    }

    @Step("Add {0} to the cart")
    public void adItems(@NotNull List<String> items) {
//        for(String itemName:items){
//            item(itemName);
//        }

        items.forEach(this::addItem);
    }

    @Step("Open the chopping cart page")
    public void openCart() {
       $(ShoppingCartIcon.link()).click();
    }

    public List<String> displayedItems() {
        return findAll(".inventory_item_name").texts();
    }
}
