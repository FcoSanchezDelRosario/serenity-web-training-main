package todomvc;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
public class WhenFilteringTasks {

    @Managed(driver= "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    private List<String> todoItems;
    private String itemToComplete;
    private String filterBy;
    private List<String> filteredItems;

    public WhenFilteringTasks(String filterBy,
                              List<String> todoItems,
                              String itemToComplete,
                              List<String> filteredItems) {
        this.todoItems = todoItems;
        this.itemToComplete = itemToComplete;
        this.filterBy = filterBy;
        this.filteredItems = filteredItems;
    }

    @TestData(columnNames =  "Filter By, Todo Items, Completed Items,Filtered Items")
    public static Collection<Object[]> testData(){
        return asList(
                new Object[][]{
                        {"Active", asList("Feed the cat", "Walk the dog"),"Feed the cat", asList("Walk the dog")},
                        {"Completed", asList("Feed the cat", "Walk the dog"),"Feed the cat", asList("Feed the cat")},
                        {"All", asList("Feed the cat", "Walk the dog"),"Feed the cat", asList("Feed the cat","Walk the dog")},
                }
        );
    }

    @Test
    public void shouldDisplayCorrectlyFilteredItems(){
        todoList.openApplication();
        todoList.addItems(todoItems);
        todoList.completeItem(itemToComplete);

        todoList.filterBy(filterBy);

        assertThat(todoList.items()).containsExactlyElementsOf(filteredItems);
    }

}
