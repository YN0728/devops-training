package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static config.Config.BASE_API_URL;

public class RequestSpecSetup {

    public static RequestSpecification setupSpec(final String baseUrl, final String basePath) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(basePath)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static RequestSpecification setUpTutorialAPI(final String basePath) {
        return setupSpec(BASE_API_URL, basePath);
    }
}
