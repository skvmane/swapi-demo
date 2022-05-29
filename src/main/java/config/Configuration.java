package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:api.properties"
})
public interface Configuration extends Config {

    @DefaultValue("https://swapi.dev/api")
    String baseURI();

    @DefaultValue("true")
    Boolean logAll();

    @DefaultValue("3")
    int maxRetryAttempts();
}