package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static Properties config;

    public static Properties getConfig() {
        if(config == null) {
            try {
                FileInputStream configFile = new FileInputStream(System.getProperty("user.dir") + "//src//test///resources//config.properties");
                config = new Properties();
                config.load(configFile);
            } catch (IOException e) {
                return null;
            }
        }

        return config;
    }
}
