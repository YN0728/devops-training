package ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Add;
import pages.Tutorials;
import utils.TestUtils;

public class AddTests extends BaseTest {

    final ThreadLocal<Tutorials> tutorialsPage = new ThreadLocal<>();
    final ThreadLocal<Add> addTutorialPage = new ThreadLocal<>();

    @BeforeMethod
    private void openPage(){
        tutorialsPage.set(new Tutorials());
        tutorialsPage.get().open();
        addTutorialPage.set(tutorialsPage.get().navigateToAddPage());
    }

    @Test
    public void addNewTutorial() {
        addTutorialPage.get().addTutorial("tutorial " + TestUtils.RANDOM.nextInt(), "Any description from FE");
        addTutorialPage.get().checkSuccessPage();
    }

    @Test
    public void addNextTutorial() {
        addTutorialPage.get().addTutorial("tutorial " + TestUtils.RANDOM.nextInt(), "Any description from FE");
        addTutorialPage.get().addNextTutorial("next tutorial " + TestUtils.RANDOM.nextInt(), "next tutorial");
        addTutorialPage.get().checkSuccessPage();
    }

}
