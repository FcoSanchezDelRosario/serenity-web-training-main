package todomvc.actions;


import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static todomvc.actions.TodoListForm.*;

public class TodoListActions extends UIInteractionSteps {

    @Step("Open the TodoMVC application")
    public void openApplication() {
        openUrl("https://todomvc.com/examples/angularjs/#/");
    }

    @Step("Adding item {0}")
    public void addItem(String item) {
        $(NEW_TODO_FIELD).typeAndEnter(item);
    }

    @Step("Add items {0}")
    public void addItems(@NotNull String... items) {
        for (String item : items) {
            addItem(item);
        }
    }

    @Step("Destroying list")
    public void destroyList() {
        $(DESTROY_LIST).click();
    }

    @Step("Complete item {0}")
    public void completeItem(String item) {
        $(COMPLETE_CHECKBOX, item).click();
    }

    @Step("Filter by {0}")
    public void filterBy(String filterName) {
        $(FILTER_BUTTON, filterName).click();
    }

    @Step("Delete item {0}")
    public void deleteItem(String item) {
        $(ITEM_LABEL, item).click();
        $(DELETE_ICON, item).click();
    }

    public List<String> items() {
        return $$(ITEM_LABELS).texts();
    }
}
