package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.json.JSONObject;

import static config.Config.BASE_UI_URL;

public class Tutorials extends BasePage {

    private static final SelenideElement searchInput = Selenide.$("[type='text']");
    private static final SelenideElement searchButton = Selenide.$("[class*='MuiButton-outlinedSizeSmall'][type='button']");
    private static final ElementsCollection tutorials = Selenide.$$("[class='list-group'] [aria-disabled='false']");
    private static final SelenideElement removeAllButton = Selenide.$("[class*='MuiButton-containedSizeSmall'][type='button']");
    private static final SelenideElement addPageNavigator = Selenide.$("[href='/add']");

    public void searchTutorial(final JSONObject tutorial) {
        searchInput.setValue(tutorial.getString("title"));
        searchButton.click();
    }

    public void checkSearchResult(final JSONObject tutorial) {
        tutorials.get(0).shouldHave(Condition.text(tutorial.getString("title")));
    }

    public void removeAllTutorials() {
        removeAllButton.click();
    }

    public void open(){
        open(BASE_UI_URL);
    }

    public Tutorials(){
        super();
    }

    public Add navigateToAddPage() {
        addPageNavigator.click();
        return new Add();
    }
}
