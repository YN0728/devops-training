package helpers.builders;

import org.json.JSONObject;

import java.util.function.Supplier;

import static utils.TestUtils.RANDOM;

public class TutorialBodyBuilder {

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";

    public enum BodyParams{
        NONE,
        ALL,
        ONLY_TITLE,
        ONLY_DESCRIPTION
    }

    private static final Supplier<JSONObject> emptyBody = JSONObject::new;

    private static final Supplier<JSONObject> onlyTitle = () -> {
        final JSONObject body = emptyBody.get();
        body.put(TITLE, "title " + RANDOM.nextInt());
        return body;
    };

    private static final Supplier<JSONObject> onlyDescription = () -> {
        final JSONObject body = emptyBody.get();
        body.put(DESCRIPTION, "description " + RANDOM.nextInt());
        return body;
    };

    private static final Supplier<JSONObject> all = () -> {
        final JSONObject body = onlyTitle.get();
        body.put(DESCRIPTION, "description " + RANDOM.nextInt());
        return body;
    };

    public static JSONObject build(BodyParams bodyParams){
        return switch (bodyParams){
            case ALL -> all.get();
            case NONE -> emptyBody.get();
            case ONLY_TITLE -> onlyTitle.get();
            case ONLY_DESCRIPTION -> onlyDescription.get();
        };
    }

}
