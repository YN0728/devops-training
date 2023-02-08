package helpers;

import endpoints.TutorialsEndpoints;
import helpers.builders.TutorialBodyBuilder;
import org.json.JSONObject;

import static helpers.builders.TutorialBodyBuilder.BodyParams.ALL;
import static org.apache.http.HttpStatus.*;

public class TutorialHelpers {

    public JSONObject createTutorial(){
        final JSONObject tutorial = TutorialBodyBuilder.build(ALL);
        return new JSONObject(TutorialsEndpoints.createTutorial(tutorial)
                .then()
                .statusCode(SC_OK)
                .extract().body().asString());
    }
}
