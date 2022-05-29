package tests.starships_service;

import models.starship.StarshipModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service_managers.starship_service.StarshipServiceApiManager;
import tests.BaseApiTest;

import static org.assertj.core.api.Assertions.assertThat;

public class StarshipFunctionalTests extends BaseApiTest {
    private StarshipServiceApiManager starshipServiceApiManager;

    @BeforeClass
    public void setup() {
        starshipServiceApiManager = new StarshipServiceApiManager();
    }

    @Test(testName = "Check GET /starships/{id} endpoint by ship name")
    public void testStarshipName() {
        StarshipModel foundShip = starshipServiceApiManager.getStarshipById(9, 200);
        assertThat(foundShip.getName()).isEqualTo("Death Star");
    }
}
