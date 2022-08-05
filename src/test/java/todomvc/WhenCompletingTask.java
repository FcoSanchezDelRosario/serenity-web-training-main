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
public class WhenCompletingTask {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoListActions todoList;

    @Before
    public void openApplication(){
        todoList.openApplication();
    }

    //TODO: Exercise 3
    @Test
    public void activeTaskShouldNotShowCompetedTasks(){
        //Add "Feed the cat" and "Walk the dog" to the list
        todoList.addItems("Feed the cat","Walk the dog");

        //Complete "Feed the cat"
        todoList.completeItem("Feed the cat");

        //Filter by "Active"
        todoList.filterBy("Active");

        //Check that only "Walk the dog" appears
        assertThat(todoList.items()).containsExactly("Walk the dog");
    }

    //TODO: Exercise 4
    @Test
    public void competedTaskShouldNotShowActiveTasks(){
        //Add "Feed the cat" and "Walk the dog" to the list
        todoList.addItems("Feed the cat","Walk the dog");

        //Complete "Feed the cat"
        todoList.completeItem("Feed the cat");

        //Filter by "Completed"
        todoList.filterBy("Completed");

        //Check that only "Walk the dog" appears
        assertThat(todoList.items()).containsExactly("Feed the cat");
    }
}
