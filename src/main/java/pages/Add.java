package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class Add extends BasePage {

    private static final SelenideElement titleInput = Selenide.$("[name='title']");
    private static final SelenideElement descriptionInput = Selenide.$("[name='description'][type='text']");
    private static final SelenideElement submitButton = Selenide.$x("//*[@type='button']/span[contains(text(), 'Submit')]");
    private static final SelenideElement successText = Selenide.$x("//*[@type='button']/parent::div");
    private static final SelenideElement addButton = Selenide.$x("//*[@type='button']/span[contains(text(), 'Add')]");
    private static final SelenideElement tutorialPageNavigator = Selenide.$("[href='/tutorials']");


    public void addTutorial(final String title, final String description) {
        titleInput.setValue(title);
        descriptionInput.setValue(description);
        submitButton.click();
    }

    public void checkSuccessPage(){
        successText.shouldHave(Condition.text("You submitted successfully!"));
        addButton.should(Condition.appear);
    }

    public void addNextTutorial(final String title, final String description){
        addButton.click();
        addTutorial(title, description);
    }
}
