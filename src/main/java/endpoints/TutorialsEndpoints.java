package endpoints;

import config.RequestSpecSetup;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;


public class TutorialsEndpoints extends RequestSpecSetup {

    public static Response createTutorial(final JSONObject body) {
        return given()
                .spec(setUpTutorialAPI("/tutorials"))
                .body(body.toString())
                .post();
    }

    public static Response getTutorials() {
        return given()
                .spec(setUpTutorialAPI("/tutorials"))
                .get();
    }

    public static Response searchTutorials(final String title) {
        return given()
                .spec(setUpTutorialAPI("/tutorials"))
                .queryParam("title", title)
                .get();
    }

    public static Response deleteTutorials() {
        return given()
                .spec(setUpTutorialAPI("/tutorials"))
                .delete();
    }
}
