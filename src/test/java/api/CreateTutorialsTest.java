package api;

import endpoints.TutorialsEndpoints;
import helpers.builders.TutorialBodyBuilder;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static helpers.builders.TutorialBodyBuilder.DESCRIPTION;
import static helpers.builders.TutorialBodyBuilder.TITLE;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.hamcrest.Matchers.equalTo;

import static org.apache.http.HttpStatus.SC_OK;

public class CreateTutorialsTest {

    @Test
    public void createTestWithProperInfo(){
        final JSONObject body = TutorialBodyBuilder.build(TutorialBodyBuilder.BodyParams.ALL);
        TutorialsEndpoints.createTutorial(body)
                .then()
                .statusCode(SC_OK) // SC_CREATED
                .body("title", equalTo(body.getString(TITLE)))
                .body("description", equalTo(body.getString(DESCRIPTION)));
    }

    @Test
    public void createTestWithOnlyTitle(){
        final JSONObject body = TutorialBodyBuilder.build(TutorialBodyBuilder.BodyParams.ONLY_TITLE);
        TutorialsEndpoints.createTutorial(body)
                .then()
                .statusCode(SC_OK) // SC_CREATED
                .body("title", equalTo(body.getString(TITLE)))
                .body("description", equalTo(null));
    }

    @Test
    public void createTestWithOnlyDescription(){
        final JSONObject body = TutorialBodyBuilder.build(TutorialBodyBuilder.BodyParams.ONLY_DESCRIPTION);
        TutorialsEndpoints.createTutorial(body)
                .then()
                .statusCode(SC_BAD_REQUEST);
    }
}
