package tests.starships_service;

import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service_managers.starship_service.StarshipServiceApiManager;

public class StarshipContractTests {
    private StarshipServiceApiManager starshipServiceApiManager;

    @BeforeClass
    public void setup() {
        starshipServiceApiManager = new StarshipServiceApiManager();
    }

    @Test(testName = "Validate GET /starships/{id} schema")
    public void testStarshipByIdSchema() {
        int shipId = RandomUtils.nextInt(1, 10);
        starshipServiceApiManager.validateStarshipByIdSchema(9);
    }
}
