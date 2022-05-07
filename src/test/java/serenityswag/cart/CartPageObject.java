package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    @FindBy(css = ".title")
    WebElementFacade title;


    @FindBy(className ="cart_item")
    List<WebElementFacade> cartItems;

    public void checkout(){
        checkoutButton.click();
    }

    public String getTitleText(){
        return title.getText();
    }

    public List<CartItem> items() {
        return null;
    }

}
