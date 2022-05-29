package tests;


import config.ConfigManager;
import config.Configuration;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.BeforeSuite;

public class BaseApiTest {
    protected static Configuration configuration;

    private static void setLogLevel() {
        if (configuration.logAll()) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
        } else {
            RestAssured.filters(new AllureRestAssured());
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        }
    }

    @BeforeSuite
    public void setupTests() {
        configuration = ConfigManager.getConfiguration();
        setLogLevel();
    }
}
