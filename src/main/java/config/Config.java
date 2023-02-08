package config;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static final Properties PROPERTIES = new Properties();
    private static final String ENV_PROPS = "configurations/env.properties";
    public static final String BASE_UI_URL;
    public static final String BASE_API_URL;

    static {
        loadProps(ENV_PROPS);
        BASE_UI_URL = PROPERTIES.getProperty("base.ui.url");
        BASE_API_URL = PROPERTIES.getProperty("base.api.url");
    }

    private static void loadProps(final String propFileName){
        try(InputStream inputStream = Config.class.getClassLoader().getResourceAsStream(propFileName)) {
           if (inputStream!=null){
               PROPERTIES.load(inputStream);
           }else {
               throw new FileNotFoundException("file " + ENV_PROPS + "not found");
           }
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

}
