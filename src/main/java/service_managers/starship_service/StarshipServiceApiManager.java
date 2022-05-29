package service_managers.starship_service;


import config.ConfigManager;
import io.restassured.response.ValidatableResponse;
import models.starship.StarshipModel;
import service_managers.RestClient;
import wrappers.ResponseWrapper;

import static specs.staship_service.StarshipServiceSpec.buildStarshipServiceSpec;


public class StarshipServiceApiManager extends RestClient {
    private static final String BASE_URL = ConfigManager.getConfiguration().baseURI();
    private static final String STARSHIPS_ID_ENDPOINT = "/starships/%s";
    private static final String STARSHIPS_ID_SCHEMA_PATH = "schemas/starship_service/getStarshipResponseSchema.json";

    private ResponseWrapper<StarshipModel> usersDefaultResponseWrapper;

    public StarshipServiceApiManager() {
        configure(buildStarshipServiceSpec().baseUri(BASE_URL));
    }

    public StarshipModel getStarshipById(int shipId, int statusCode) {
        String path = String.format(STARSHIPS_ID_ENDPOINT, shipId);
        return get(path, StarshipModel.class).expectingStatusCode(statusCode).readEntity();
    }

    public ValidatableResponse validateStarshipByIdSchema(int shipId) {
        String path = String.format(STARSHIPS_ID_ENDPOINT, shipId);
        return get(path).validateSchema(STARSHIPS_ID_SCHEMA_PATH);
    }
}
