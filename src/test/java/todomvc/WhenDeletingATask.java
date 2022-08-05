package todomvc;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenDeletingATask {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @Before
    public void openApplication(){
        todoList.openApplication();
    }

    //TODO: Exercise 5
    @Test
    public void deletedItemsShouldDissappearFromTheList(){
        //Add "Feed the cat" and "Walk the dog" to the list
        todoList.addItems("Feed the ferret","Walk the alpaca");

        //Delete "Feed the cat"
        todoList.deleteItem("Feed the ferret");

        //Check that only "Walk the dog" appears
        assertThat(todoList.items()).containsExactly("Walk the alpaca");
    }
}
