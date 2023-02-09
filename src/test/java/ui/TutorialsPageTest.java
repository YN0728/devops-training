package ui;

import helpers.TutorialHelpers;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import pages.Tutorials;

public class TutorialsPageTest extends BaseTest{

    private final ThreadLocal<Tutorials> tutorialsPage = new ThreadLocal<>();
    private JSONObject tutorial;

    @BeforeClass
    private void setup(){
        tutorial = new TutorialHelpers().createTutorial();
    }

    @BeforeMethod
    private void openPage(){
        tutorialsPage.set(new Tutorials());
        tutorialsPage.get().open();
    }

    @Test
    public void searchTutorial() {
        tutorialsPage.get().searchTutorial(tutorial);
        tutorialsPage.get().checkSearchResult(tutorial);
    }

}
