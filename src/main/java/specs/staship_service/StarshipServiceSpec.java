package specs.staship_service;

import config.ConfigManager;
import config.Configuration;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class StarshipServiceSpec {

    private StarshipServiceSpec() {
    }

    public static RequestSpecification buildStarshipServiceSpec() {
        Configuration configuration = ConfigManager.getConfiguration();
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}
