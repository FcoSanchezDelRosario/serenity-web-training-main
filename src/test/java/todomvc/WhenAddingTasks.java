package todomvc;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.actions.TodoListActions;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SerenityRunner.class)
public class WhenAddingTasks {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @Before
    public void openApplication(){
        todoList.openApplication();
    }

    //TODO : Exercise 1
    @Test
    public void WhenAddingTasks(){
        //Add "Feed the Cat" to the list
        todoList.addItem("Feed the Cat");

        //Check the "Feed The Cat" appears in the list
        assertThat(todoList.items()).containsExactly("Feed the Cat");

    }

    //TODO : Exercise 2
    @Test
    public void addingMultipleTasks(){
        // Add "Feed the Cat" and "Walk the dog" to the list
        todoList.addItems("Feed the Cat","Walk the dog");

        //Check that they all appear in the list
        assertThat(todoList.items())
                .containsExactly("Feed the Cat","Walk the dog");
    }

    @After
    public void destroyList(){
        todoList.destroyList();
    }
}
