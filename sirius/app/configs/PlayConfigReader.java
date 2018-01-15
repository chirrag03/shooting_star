package configs;


import javax.inject.Inject;
import javax.inject.Singleton;

import play.Configuration;

@Singleton
public class PlayConfigReader {

    private static Configuration config;

    @Inject
    public PlayConfigReader(Configuration configuration) {
        config = configuration;
    }

    public static String getValue(String key){
        return config.getString(key);
    }
}
