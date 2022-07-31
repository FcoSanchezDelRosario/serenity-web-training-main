package todomvc.actions;


import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class TodoListActions extends UIInteractionSteps {

    @Step("Open the TodoMVC application")
    public void openApplication() {
        openUrl("https://todomvc.com/examples/angularjs/#/");
    }

    @Step("Adding item {0}")
    public void addItem(String item) {
        $(".new-todo").typeAndEnter(item);
    }

    @Step("Add items {0}")
    public void addItems(String... items) {
        for (String item : items) {
            addItem(item);
        }
    }

    @Step("Destroying list")
    public void destroyList() {
        $(".destroy").click();
    }

    public List<String> items() {
        return $$(".todo-list label").texts();
    }

}
