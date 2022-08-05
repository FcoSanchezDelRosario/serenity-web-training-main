package todomvc.actions;

import org.openqa.selenium.By;

class TodoListForm {
    static final By NEW_TODO_FIELD= By.className("new-todo");
    static final String ITEM_LABELS = ".todo-list label";
    static final String COMPLETE_CHECKBOX= "//label[.='{0}']/preceding-sibling::input[@type='checkbox']";
    static final String FILTER_BUTTON = "//ul[@class='filters']//a[.='{0}']";
    static final String DESTROY_LIST = ".destroy";

    static final String ITEM_LABEL= "//label[.='{0}']";
    static final String DELETE_ICON = "//label[.='{0}']/following-sibling::button[@class='destroy']";
}
